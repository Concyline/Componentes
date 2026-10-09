# Catálogo Técnico de Componentes

**Status:** `CATALOG`
**Última atualização:** `2026-10-09`
**Fonte:** código Java, recursos Android e configuração Gradle do repositório.

Este catálogo descreve os tipos Java e atributos XML encontrados no módulo `:componentes`. É um inventário técnico do estado observado, não uma garantia de compatibilidade além dos contratos públicos que o código efetivamente implementa. Consulte a documentação do módulo em [`MODULOS.md`](../DOCUMENTACAO_TECNICA/MODULOS.md) para conhecer a relação com o app de demonstração.

## 1. Como consumir

No repositório, o aplicativo de demonstração inclui a biblioteca por dependência de projeto:

```groovy
implementation project(':componentes')
```

Views que aceitam atributos XML podem ser declaradas com seu nome totalmente qualificado e o namespace `app`:

```xml
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <br.com.componentes.EditTextTitle
        android:id="@+id/email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:title="E-mail"
        app:hint="Digite seu e-mail"
        app:requerido="true" />
</FrameLayout>
```

```java
if (email.validaPreenchido()) {
    String valor = email.getString();
}
```

Para ver exemplos executáveis dos componentes visuais, abra o app `:app` e consulte `MainActivity` e `activity_main.xml`. As amostras são dispostas verticalmente; botões demonstram os componentes baseados em diálogo, que não são views declarativas.

Use somente atributos listados para o `declare-styleable` do componente. Os atributos customizados não são automaticamente aceitos por toda view da biblioteca. A integração externa à árvore do repositório deve confirmar previamente a coordenada e a disponibilidade da publicação: a configuração Maven/JitPack, sozinha, não confirma que um artefato foi publicado.

## 2. Mapa rápido por necessidade

| Necessidade | Componentes a avaliar |
|---|---|
| Campo com rótulo, validação de obrigatório, máscara e ícones | `EditTextTitle` |
| Campo com sugestões/autocomplete | `EditTextTitleAutoComplete` |
| Campo monetário composto ou baseado em `EditText` | `EditTexCurrency` ou `currency.CurrencyEditText`; são APIs diferentes |
| Seleção de data | `EditTextCalendar`; `EditTextTitle` e `EditTextTitleAutoComplete` também expõem helpers de data |
| Pesquisa | `EditTextSearch` |
| Seleção em lista suspensa | `SpinnerTitle` |
| Texto de rótulo e descrição | `TextViewTitle` |
| Diálogo customizado, alerta ou teclado numérico | `CustomDialog`, `CDialog`, `KeyBoardDialog`, `HelpButton` |
| Indicação de carregamento | `ProgressButton`, `ProgressImageView`, `ProgressIndeterminate`, `DotLoader`, `GeometricProgressView` |
| Lista e gestos | `BaseAdapter`, `RecyclerViewButton`, `SwipeLayout` |
| Imagens recortadas, arredondadas ou animadas | `ImageViewCustom`, `RoundImageView`, `RoundishImageView`, `ZoomFrameImageView` |
| Máscaras, documentos brasileiros, datas e animações | Pacote `br.com.componentes.Util` |

## 3. Inventário de views e componentes de interface

| Tipo | Localização / base | Uso e API observada | Limitações e cuidados |
|---|---|---|---|
| `EditTextTitle` | `br.com.componentes.EditTextTitle`; `FrameLayout` | Campo composto com título, texto de entrada, ícones, hint, máscara, estado obrigatório e validação. API inclui `setText`, `getString`, `setLegenda`, `setHint`, `setEnabled`, `setFocus`, `setError`, `removeError`, `validaPreenchido`, `validaCpfCnpj`, `addTextChangedListener`, callbacks de ícone, `setMascara` e helpers de data. | `getInteger()` e `getDouble()` retornam `0`/`0.0` se o texto não puder ser convertido; não distinguem falha de um zero válido. `setMascara(int)` oferece tratamento explícito de CPF/CNPJ; a máscara textual dinâmica é limitada a dígitos. |
| `EditTextTitleAutoComplete` | `br.com.componentes.EditTextTitleAutoComplete`; `FrameLayout` | Campo com sugestões. Além das operações comuns de `EditTextTitle`, oferece `setAdapter(Object[])`, `setAdapter(ArrayAdapter<Object>)`, `getAdapter()` e `setOnItemClickListener`. | O conteúdo e a filtragem das sugestões são responsabilidade do adapter/consumidor. Conversões numéricas têm o mesmo fallback `0`/`0.0`; valide a entrada antes de usar esses valores. |
| `EditTexCurrency` | `br.com.componentes.EditTexCurrency`; `FrameLayout` | Campo monetário composto com `setText`, `getString`, `getInteger`, `getDouble`, `setHint`, `setFilters`, listeners de texto e estado obrigatório/erro. Preserva esse nome legado, inclusive a grafia `Tex`. | Não confundir com `currency.CurrencyEditText`. Conversões inválidas retornam zero; verifique formatação e locale usados pelo componente antes de interpretar `getDouble()`. Alguns métodos herdados pelo componente, como helper de data, não indicam por si só que o campo seja um seletor de data. |
| `CurrencyEditText` | `br.com.componentes.currency.CurrencyEditText`; `AppCompatEditText` | Campo monetário independente do `EditTexCurrency`. Usa locale para formatação, controla exibição do símbolo, informa locale/casas fracionárias e oferece `setLocale`, `showSymbol`, `getCurrencyText`, `getFractionDigit` e `setDecimals`. | Implementação baseada em formatação monetária da locale. `allow_negative_values` e `decimal_digits` são declarados no styleable, mas não são lidos pela implementação observada. Não unificar seu contrato com `EditTexCurrency`. |
| `EditTextCalendar` | `br.com.componentes.EditTextCalendar`; `FrameLayout` | Campo de seleção de data com `DatePickerDialog`; `getDate()`, `getDate(boolean)`, `setDate(Date)` e `createDialogData(...)`. Formata como `dd/MM/yyyy` ou, quando `hora=true`, `dd/MM/yyyy HH:mm:ss`. `inicializa=true` preenche a data/hora atual. | `hora=true` exibe a hora armazenada e um controle que preenche a hora atual; o seletor apresentado pelo componente é `DatePickerDialog`, não um seletor de hora. `getDate()` pode retornar `null` enquanto nenhuma seleção/inicialização ocorreu. O overload `getDate(boolean)` retorna a data armazenada ou a data atual; o parâmetro booleano não altera essa decisão no código observado. |
| `EditTextSearch` | `br.com.componentes.EditTextSearch`; `FrameLayout` | Campo de pesquisa com rótulo, ícone, hint e tipo de entrada. API: `setOnClickListener` (listener do ícone), `setOnKeyListener`, `setText`, `getString`, `getStringUperCase`, `getInteger`, `getdouble`, `setInputTypeSearch` e `setHint`. | O clique configurado por `setOnClickListener` é ligado ao ícone, não ao `EditText`. Conversões inválidas retornam zero. |
| `SpinnerTitle` | `br.com.componentes.SpinnerTitle`; `FrameLayout` | Spinner com rótulo; aceita `entries` via XML, `setAdapter(ArrayAdapter<Object>)`, `setAdapter(SpinnerAdapter)`, listener de seleção e seleção programática. | Sem entradas XML, configura um adapter com item vazio. `getSelectedItemString()` chama `toString()` no item; verifique se o adapter já possui seleção/item. |
| `TextViewTitle` | `br.com.componentes.TextViewTitle`; `FrameLayout` | Apresenta título e descrição. A descrição pode ser definida como `String` ou `Spanned`; também expõe configuração de cor e fonte por asset. | `setTextColor(...)` altera a cor da descrição, não a do título. `setFont(path)` espera um arquivo de fonte disponível nos assets do contexto consumidor. |
| `HelpButton` | `br.com.componentes.HelpButton`; `FrameLayout` | Ícone de ajuda, configurável por mensagem; API `setHelpMsg` e `setActivity`. A classe interna `HelpDialog` permite configurar altura e obter toolbar/dialog. O ícone possui descrição acessível e alvo mínimo de 48dp; a ação “Ok” usa o token de foco adaptável ao tema. O contraste da ação foi conferido visualmente nos temas claro e escuro. | `setActivity(Activity)` deve ser chamado para que o toque abra o diálogo. Sem Activity, o código escreve uma mensagem no console e não exibe o diálogo. |
| `CustomDialog` | `br.com.componentes.CustomDialog` | Builder de diálogo com layout customizado, cancelabilidade, toolbar, título/subtítulo, menu, fundo e altura. Uso: configurar, chamar `create()` e então `show()`. | Requer uma `Activity` válida e `setContentView(layoutResId)` antes de `create()`; a criação declara `throws Exception` se o layout principal não estiver configurado. Menus e toolbar só podem ser consultados após a criação. |
| `CDialog` | `br.com.componentes.CDialog` | Alertas com tipos `SUCCESS`, `WARNING`, `ERROR`, `INFO`; versões com ícone, barra/aviso e opções de tamanho, posição, animação, fundo, duração e opacidade. API inclui `createAlert(...)`, `show()`, `setDuration`, `setPosition`, `setAnimation` e `setBackDimness`. A mensagem fica em área rolável, mantendo o ícone e a barra de progresso no diálogo. | O método `createAlertSneckBar` tem essa grafia no contrato atual. Tipos/opções usam enums do pacote `extras`. Mensagem extensa foi rolada manualmente no alerta oval `MEDIUM` em tema claro; valide também outros formatos, tamanhos e tema escuro. |
| `KeyBoardDialog` | `br.com.componentes.KeyBoardDialog` | Diálogo de entrada numérica customizada. `create()`, `show(valorInicial, callback)`, `dismiss()`, `setCancelable`, `setJustNumber` e ajuste de fundo. O callback `OnDismissListener` devolve uma `String`. | Recebe `Activity`; configure/crie o diálogo antes de exibi-lo. `justNumber` começa habilitado; valide o valor devolvido antes de persistir ou calcular. |
| `ProgressButton` | `br.com.componentes.ProgressButton`; `FrameLayout` | Botão que alterna entre estado normal e indicador por `setProgres()`/`removeProgres()`; listener aplicado ao botão interno. XML aceita texto, cor e tamanho do progresso. | A API só alterna a apresentação; não executa operação assíncrona, bloqueia duplicidade nem restaura estado automaticamente. O consumidor controla o ciclo. |
| `ProgressImageView` | `br.com.componentes.ProgressImageView`; `FrameLayout` | Imagem com indicador sobreposto; `setProgres()` oculta a imagem e mostra o progresso; `removeProgres()` restaura a imagem. Permite listener de clique e atributos de imagem/cor/tamanho. | O ciclo de carregamento é responsabilidade do consumidor. |
| `ProgressIndeterminate` | `br.com.componentes.ProgressIndeterminate` | Diálogo de progresso com mensagem; API fluente `create`, `setBackgroundColor`, `setTextSize`, `cancelable`, `setMessage`, `show`, `dismiss`, além de `isShowing`. Há atalho estático `show(Context, String)`. A opção `multColor` anima a paleta no thread principal e interrompe callbacks ao fechar o diálogo ou desativar a opção. | `create()` converte o `Context` para `Activity`; passe um contexto de Activity válido e respeite seu ciclo de vida. |
| `DotLoader` | `br.com.componentes.DotLoader`; `View` | Indicador animado de pontos. Atributos XML definem raio, cores e quantidade; API observada inclui `setNumberOfDots`, `resetColors` e `initAnimation`. | `Dot` e `AnimationRepeater` são tipos auxiliares associados à animação. Verifique encerramento/reativação da animação durante remoção da view ou mudança de visibilidade. |
| `GeometricProgressView` | `br.com.componentes.GeometricProgressView`; `View` | Indicador geométrico animado, com tipo `KITE`/`TRIANGLE`, número de ângulos, cor, duração e espaçamento. API: setters `setType`, `setNumberOfAngles`, `setColor`, `setDuration`, `setFigurePadding` e `setFigurePaddingInDp`. | Padrões observados: 64dp, 6 ângulos, 1500ms, 2dp e `#00897b`. `setFigurePadding` recebe pixels; use `setFigurePaddingInDp` quando o valor estiver em dp. |
| `RecyclerViewButton` | `br.com.componentes.RecyclerViewButton`; `FrameLayout` | Container de lista com `RecyclerView`, swipe-to-refresh, estado vazio, botão de retorno ao topo, divisores e grid. `setAdapter(Activity, adapter)`, listener de refresh, `scrollToPosition`, `setRefreshing`, listener de toque e `notifyDataSetChanged`. A lista e o contexto são por instância; adapter nulo exibe o estado vazio, e `notifyDataSetChanged()` notifica o adapter e atualiza esse estado. O botão de retorno ao topo tem rótulo acessível e alvo de 48dp; mudanças no estado vazio são anunciáveis. | `ItemClickListener(Listener)` preserva o construtor público e cria o detector de gestos com o contexto do `RecyclerView` que recebe os eventos. |
| `SwipeLayout` | `br.com.componentes.SwipeLayout`; `FrameLayout` | Container com arraste horizontal e ações laterais. IDs de filhos são indicados por `draggedItem`, `leftItem` e `rightItem`; API para abrir/fechar, configurar direção/arraste e receber `SwipeActionsListener.onOpen(...)`/`onClose()`. | Requer hierarquia de filhos e IDs compatíveis com a configuração. As flags `LEFT`, `RIGHT` e `HORIZONTAL` controlam direções, não rótulos de negócio das ações. Teste o conflito de gestos com views roláveis internas. |
| `ImageViewCustom` | `br.com.componentes.ImageViewCustom`; `AppCompatImageView` | Toque longo pode mostrar um popup com o valor de `tag`, que fecha após dois segundos. Com o listener interno ativo, um listener do consumidor que retorna `false` permite a exibição do popup; se retorna `true`, o popup não abre e o handler retorna `false`. | O construtor usado pelo XML registra o listener interno; o construtor `ImageViewCustom(Context)` não faz esse registro. O popup chama `getTag().toString()`, portanto exige `tag` não nulo. `setOnLongClickListener` é sobrescrito e guarda o listener do consumidor; valide a inicialização antes de depender do comportamento. |
| `RoundImageView` | `br.com.componentes.RoundImageView`; `ImageView` | Recorte circular de imagem com borda, cor de fundo, overlay e opção de desabilitar transformação circular. | Usa `CENTER_CROP`; `setScaleType` não aplica a escala recebida e `setAdjustViewBounds(true)` lança `IllegalArgumentException`. Não presumir suporte ao comportamento padrão de `ImageView` nesses métodos. |
| `RoundishImageView` | `br.com.componentes.RoundishImageView`; `AppCompatImageView` | Recorte com raio configurável e seleção de cantos por flags `CORNER_TOP_LEFT`, `CORNER_TOP_RIGHT`, `CORNER_BOTTOM_RIGHT`, `CORNER_BOTTOM_LEFT` e `CORNER_ALL`. | O raio é lido como dimensão XML; o setter `setCornerRadius(int)` recebe pixels. Confira desempenho/renderização em API e layouts relevantes ao alterar clipping. |
| `ZoomFrameImageView` | `br.com.componentes.ZoomFrameImageView`; `AppCompatImageView` | Exibe imagem com transições animadas de zoom/pan. Aceita bitmap, drawable, resource e URI; `restart`, `pause`, `resume`, `setTransitionGenerator` e `setTransitionListener`. | Define transformação matricial própria; `setScaleType` não altera o modo. A transição requer bounds válidos da imagem/viewport; teste atualização de imagem, tamanho, visibilidade e ciclo de vida. |
| `EspacoVago` | `br.com.componentes.EspacoVago`; `AppCompatTextView` | View leve derivada de `AppCompatTextView`, disponível para compor layouts. | O código não documenta um contrato além da view base; valide tamanho, acessibilidade e semântica no layout consumidor. |

## 4. Adaptadores e listeners

### `BaseAdapter<T>` e `OnViewHolderClickListener`

Pacote `br.com.componentes.baseadaper` (a grafia do pacote é parte do nome existente). `BaseAdapter<T>` é abstrato; recebe uma `List<T>` e opcionalmente um `OnViewHolderClickListener`. A subclasse precisa fornecer o layout de item por `getItemView()` e implementar `onBindViewHolder(...)` conforme o contrato do `RecyclerView.Adapter`.

O `ClickableViewHolder` oferece `getViewById(@IdRes int)`, construindo um cache das views identificadas no layout. Um ID não encontrado no cache resulta em `Resources.NotFoundException`. O listener informa posição por `onClickListener(int)` e `onLongClickListener(int)`. Helpers estáticos criam `GridLayoutManager`, `LinearLayoutManager` e `DividerItemDecoration` para `AppCompatActivity`.

**Cuidados:** valide a posição em cenários de atualização/remoção de itens e prefira o adapter do `RecyclerView` quando este helper não atender ao layout ou ao ciclo de dados necessário.

### `RecyclerViewButton.Listener` e `ItemClickListener`

O listener do componente fornece callbacks de clique simples e longo com a `View` e a posição. Registre-o por um `RecyclerView.OnItemTouchListener` criado com `new RecyclerViewButton.ItemClickListener(listener)` e adicione-o com `addOnItemTouchListener`.

## 5. Campos XML customizados

Os atributos estão declarados em `componentes/src/main/res/values/attr.xml`. Os nomes/capitalização abaixo são contratos literais; por compatibilidade, a documentação preserva grafias como `iconRigth`, `coricon`, `requerido` e `tamTitle`.

### Views de texto e entrada

| `declare-styleable` | View associada pelo código | Atributos declarados |
|---|---|---|
| `EditTextLegenda` | `EditTextTitle` e `EditTextTitleAutoComplete` | `title`, `tamTitle`, `colorTitle`, `colorText`, `tamTitleEditText`, `tamTextEditText`, `hint`, `text`, `lines`, `maxLength`, `iconLeft`, `iconRigth`, `coricon`, `enabled`, `focusable`, `requestfocus`, `requerido`, `isDate`, `isDateHour`, `iconRigthVisible`, `tag`, `mascara`, `singleLine`, `inputType`, `legendaRequerido` |
| `EditTextCurrencyLegenda` | `EditTexCurrency` | `title`, `colorTitle`, `tamTitleEditText`, `tamTextEditText`, `hint`, `text`, `tamTitle`, `maxLength`, `coricon`, `enabled`, `focusable`, `requestfocus`, `requerido`, `tag`, `mascara`, `singleLine`, `inputType`, `legendaRequerido`, `showSymbol`, `locale` |
| `EditTextCalendarLegenda` | `EditTextCalendar` | `tamTitleEditText`, `title`, `colorTitle`, `tamTitle`, `tamTextEditText`, `hora`, `inicializa` |
| `SearchLegenda` | `EditTextSearch` | `title`, `colorTitle`, `tamTitle`, `tamTitleEditText`, `tamTextEditText`, `mascara`, `hint`, `enabled`, `focusable`, `requestfocus`, `coricon`, `inputType` |
| `SpinnerLegenda` | `SpinnerTitle` | `entries`, `tamTitle`, `title`, `colorTitle`, `tamTitleEditText` |
| `TextViewLegenda` | `TextViewTitle` | `gravity`, `title`, `colorTitle`, `tamTitle`, `descricao`, `corDescricao`, `tamDescricao`, `singleLine` |
| `currencyEditText` | `currency.CurrencyEditText` | `locale`, `showSymbol`, `decimalPoints`, `allow_negative_values`, `decimal_digits` |
| `HelpButton` | `HelpButton` | `color`, `helpMsg` |

`CurrencyEditText` (`br.com.componentes.currency`) lê `locale`, `showSymbol` e `decimalPoints` no código observado. `allow_negative_values` e `decimal_digits` constam no styleable, mas não foi encontrado consumo desses dois atributos pela implementação; não conte com eles como configuráveis até que o código e os testes confirmem esse contrato.

Em `EditTextSearch`, `mascara` é lido mas não aplicado e `tamTitleEditText` é declarado no styleable, porém não é lido pela implementação observada. Não dependa desses atributos para obter máscara ou controlar o tamanho do título sem primeiro validar/corrigir esse comportamento.

### Imagens, progresso, gesto e lista

| `declare-styleable` | View associada | Atributos declarados |
|---|---|---|
| `RoundishImageView` | `RoundishImageView` | `cornerRadius`, `roundedCorners` (`topLeft=1`, `topRight=2`, `bottomRight=4`, `bottomLeft=8`, `all=15`) |
| `RoundImageView` | `RoundImageView` | `borderWidth`, `borderColor`, `civ_border_overlay`, `civ_circle_background_color` |
| `ProgressImageView` | `ProgressImageView` | `src`, `progressColor`, `progressSize` |
| `ProgressButton` | `ProgressButton` | `text`, `progressColor`, `progressSize` |
| `SwipeLayout` | `SwipeLayout` | `swipeDirection` (`left=1`, `right=2`), `isEnabledSwipe`, `isFreeDragAfterOpen`, `isFreeHorizontalDrag`, `isContinuousSwipe`, `isTogether`, `rightItem`, `leftItem`, `draggedItem`, `autoMovingSensitivity`, `rightDragViewPadding`, `leftDragViewPadding` |
| `GeometricProgressView` | `GeometricProgressView` | `gp_type` (`kite=0`, `triangle=1`), `gp_number_of_angles`, `gp_color`, `gp_duration`, `gp_figure_padding`, `gp_style` |
| `DotLoader` | `DotLoader` | `dot_radius`, `color_array`, `number_of_dots` |
| `RecyclerViewButton` | `RecyclerViewButton` | `locationButton`, `numberOfColumns`, `horizontalDivider`, `verticalDivider`, `refresh`, `basic`, `listitem` |

Valores de `locationButton`: `center=0`, `left=1`, `right=2`, `none=3`; o padrão da view é `center`. Confira o comportamento em layouts diferentes antes de definir configuração customizada.

### Atributos compartilhados

O arquivo de recursos declara ainda `title` (string), `colorTitle`/`colorText`/`coricon` (cor), `tamTitle`/`tamTextEditText`/`tamTitleEditText` (dimensão), `mascara`/`hint`/`legendaRequerido`/`text`/`tag` (string), `enabled`/`focusable`/`requestfocus`/`singleLine`/`requerido`/`showSymbol` (boolean), `progressColor` (cor), `progressSize` (dimensão), `maxLength` (inteiro) e `locale` (string). `lines` também é declarado nos styleables de campo como inteiro.

Os valores aceitos para `inputType` nos recursos são `none`, `textPassword`, `numberDecimal`, `textMultiLine`, `textMultiLineAllCaps`, `textCapCharacters`, `number` e `textEmailAddress`. A conversão para tipos nativos está em `Util.InputType.setInputType(...)`.

## 6. Utilitários e tipos de apoio

| Tipo | Localização | Responsabilidade e API observada |
|---|---|---|
| `Constantes` | `br.com.componentes.Util` | Constantes numéricas de tipos de entrada e máscaras (CPF, CNPJ, CEP, telefone, DDD e aniversário). |
| `InputType` | `br.com.componentes.Util` | `setInputType(EditText, int, int)` aplica tipo de teclado, capitalização e configuração multilinha para os códigos suportados. |
| `Mascara` | `br.com.componentes.Util` | Aplica máscara textual numérica a um `EditText`; espaços na máscara representam posições de dígitos. `changeMask` troca a máscara instalada. A lógica especial para `tag="telefone"` limita o telefone a nove dígitos. |
| `Util` | `br.com.componentes.Util` | Animações `fadeIn`/`shake` e formatação de datas `dateToStr` (`dd/MM/yyyy`) e `dateHora` (`dd/MM/yyyy hh:mm`). O formato de hora usa `hh` (12 horas) no código atual. |
| `ValidaCPF` | `br.com.componentes.Util` | `isCPF` remove caracteres não numéricos e valida 11 dígitos/dígitos verificadores; `imprimeCPF` formata uma string em posições fixas. |
| `ValidaCNPJ` | `br.com.componentes.Util` | `isCNPJ` remove caracteres não numéricos e valida 14 dígitos/dígitos verificadores; `imprimeCNPJ` formata uma string em posições fixas. |
| `TypeDialog` | `br.com.componentes.extras` | Tipos `SUCCESS`, `WARNING`, `ERROR`, `INFO`. |
| `SizeDialog`, `SizeText` | `br.com.componentes.extras` | Opções `SMALL`, `MEDIUM`, `LARGE`, `XLARGE`. |
| `PositionDialog` | `br.com.componentes.extras` | `POSITION_BOTTOM`, `POSITION_TOP`, `POSITION_CENTER`. |
| `AnimateDialog` | `br.com.componentes.extras` | Opções enumeradas de animações de escala/deslizamento usadas pelo `CDialog`. |
| `WindowFormat` | `br.com.componentes.extras` | `BACKGROUND_OVAL`, `BACKGROUND_RECTANGLE`. |
| `Figure`, `TYPE` | `br.com.componentes.geometricprogress` | Primitiva de desenho e tipos `TRIANGLE`/`KITE` usados pelo indicador geométrico. |
| `AnimationRepeater`, `CubicBezierInterpolator`, `Dot` | `br.com.componentes.dotloader` | Tipos auxiliares do `DotLoader`: ciclo de cores, interpolação Bézier e desenho/estado de ponto. |
| `IncompatibleRatioException`, `MathUtils`, `Transition`, `TransitionGenerator`, `RandomTransitionGenerator` | `br.com.componentes.zoom` | Tipos de suporte à transição de imagem: exceção de proporção, cálculo geométrico, retângulos/tempos interpolados e geração da próxima transição. |

`imprimeCPF` e `imprimeCNPJ` formatam por índices fixos e pressupõem texto com comprimento suficiente; valide tamanho e conteúdo antes de chamá-los. Os validadores não substituem validações de negócio ou verificações em servidor.

## 7. Restrições transversais observadas

- O namespace da biblioteca é `br.com.componentes`; mantenha pacote, IDs XML e nomes de atributos existentes ao ampliar contratos públicos.
- O módulo define `minSdk 23`, `compileSdk 36` e Java 17. O catálogo não atesta que cada componente foi testado em todas as versões suportadas.
- Recursos compartilhados estão em `componentes/src/main/res/`; fontes estão em `componentes/src/main/assets/fonts/`. Mudanças a recursos usados por várias views podem ter impacto amplo.
- Há API pública escrita em Java com nomes e grafias legadas. Renomear classes, métodos, atributos, enums ou pacotes pode quebrar apps consumidores.
- As dependências declaradas incluem AndroidX AppCompat, Material Components e SwipeRefreshLayout; não há declaração de backend ou persistência própria da biblioteca.
- A presença de dependências de teste não comprova cobertura automatizada. Não foram localizados testes nos módulos durante o levantamento deste catálogo.
- A biblioteca oferece tokens semânticos claros/escuros para superfícies, textos, estados, bordas e diálogos; a validação completa de acessibilidade em todas as combinações de componentes/temas e a política de depreciação permanecem pendentes.

## 8. Manutenção do catálogo

Atualize este arquivo quando tipos públicos, atributos XML, dependências, comportamento observável ou limitações mudarem. Revise também [`MODULOS.md`](../DOCUMENTACAO_TECNICA/MODULOS.md) se a responsabilidade ou dependência entre módulos for alterada. Para especificar em profundidade o contrato e exemplos de uma view individual, crie uma página própria usando [`TEMPLATE.md`](./TEMPLATE.md) e mantenha este catálogo como índice.
