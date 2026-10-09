# Diretrizes de Interface Android

> **Escopo:** orientações para os componentes reutilizáveis do módulo `:componentes` e para o aplicativo de demonstração `:app`.
>
> **Estado observado:** as interfaces são implementadas com views Android, layouts e recursos XML. O app de demonstração usa `Theme.Material3.DayNight.NoActionBar`. A biblioteca fornece tokens semânticos de cor em `values/colors.xml` e `values-night/colors.xml` e usa esses tokens nas superfícies, textos, estados e diálogos cobertos. Isso não significa que todo conteúdo fornecido pelo consumidor ou toda combinação de tema tenha sido validada como acessível.
>
> **Decisões pendentes:** não há especificação de design aprovada, escala tipográfica, paleta oficial, política completa de temas ou matriz de dispositivos suportados identificada na documentação consultada. Não tratar exemplos de layouts ou valores existentes como tokens obrigatórios do produto.

## 1. Objetivo

Definir orientações para criar e manter interfaces Android coerentes, adaptáveis, acessíveis e compatíveis com a arquitetura desta biblioteca. Os componentes existentes devem ser consultados e reutilizados antes de criar outro elemento com responsabilidade equivalente.

Este guia orienta a implementação; não substitui requisitos funcionais, decisões de design ou contratos públicos dos componentes.

## 2. Padrões da interface do projeto

- Implemente a interface com as views e recursos Android já adotados no módulo correspondente.
- A biblioteca declara atributos XML próprios em `componentes/src/main/res/values/attr.xml`. Antes de adicionar ou alterar um atributo, confira se já existe um equivalente e preserve sua compatibilidade.
- Prefira configurar cores, dimensões, textos e estilos por recursos Android (`res/values/`, variantes qualificadas e atributos de tema) em vez de duplicar valores diretamente nos layouts ou no código.
- Reutilize layouts e componentes de `:componentes` quando atenderem ao caso de uso. Evite dependência da biblioteca sobre o app de demonstração.
- O app usa View Binding. Preserve esse padrão ao alterar telas do módulo `:app`; não o assuma como requisito para a implementação interna da biblioteca.
- Textos visíveis ao usuário devem estar em português e, quando forem recursos da aplicação ou biblioteca, devem ser centralizados em `strings.xml`.
- Use nomes de recursos e convenções existentes no mesmo módulo. Não renomeie recursos ou atributos públicos sem avaliar o impacto em aplicativos consumidores.

## 3. Layout adaptável

- Projete primeiro para telas Android compactas e permita que o layout se adapte a tamanhos, orientações e escalas de fonte diferentes.
- Prefira `ConstraintLayout`, medidas flexíveis (`match_parent`, `wrap_content` e dimensões em `dp`) e restrições entre elementos a posicionamentos absolutos.
- Use `dp` para dimensões de layout e alvos de interação; use `sp` para texto, respeitando a escala de fonte configurada no dispositivo.
- Evite larguras, alturas e espaçamentos fixos quando puderem cortar conteúdo em telas menores ou com fontes ampliadas. Quando dimensões fixas forem necessárias ao componente, teste o comportamento em diferentes tamanhos.
- Prefira atributos de direção (`start`/`end`) a `left`/`right` para permitir layouts da esquerda para a direita e da direita para a esquerda.
- Confira estados com teclado aberto, conteúdo extenso, validação de entrada e rolagem. Elementos importantes não devem ficar inacessíveis atrás do teclado ou fora da área visível.
- Os valores encontrados em telas de demonstração são exemplos locais; não constituem uma grade de espaçamento global.

## 4. Tema, cor e recursos

- Preserve o tema do aplicativo consumidor. A biblioteca não deve impor um tema global ao app que a integra.
- Ao adicionar ou alterar estilos, cores e drawables, verifique os recursos existentes em `componentes/src/main/res/values/`, `values-night/`, `drawable/` e `drawable-night/`.
- Se um recurso tiver variantes de tema, mantenha-as sincronizadas. Não presuma suporte completo ao modo noturno apenas pela existência de alguns recursos `-night`.
- Use os tokens semânticos da biblioteca (`colorSurface`, `colorOnSurface`, `colorSurfaceVariant`, `colorOutline`, `colorFocus`, `colorDisabledSurface`, `colorDisabledContent`, `colorPrimary`, `colorOnPrimary` e `colorOnStatus`) para novas cores de interface; suas variantes claras e escuras ficam em `values/` e `values-night/`.
- Preserve os nomes legados de recursos de cor usados por consumidores. Ao mudar uma cor existente ou introduzir um token, atualize ambas as paletas sem alterar atributos XML ou setters públicos.
- Prefira recursos de cor ou atributos de tema a valores hexadecimais embutidos. Reserve valores fixos a cores cujo significado não varia com o tema, como a paleta intencional de um efeito multicolorido.
- A biblioteca não impõe tema global ao app consumidor. Verifique também diálogos, popups, spinners e estados desabilitados; uma variante noturna de drawable não garante que os textos ou os componentes dinâmicos do consumidor acompanhem o tema.
- Preserve contraste suficiente entre texto, ícones, estados e fundo. Não comunique erros, sucesso ou seleção somente por cor; use também texto, ícone ou outro sinal perceptível.
- Preserve dimensões e estilos declarados como recursos compartilhados, inclusive variantes qualificadas por densidade ou modo noturno, quando o componente depender delas.

## 5. Interação e estados

Cada componente interativo deve apresentar comportamento compreensível e feedback adequado para seus estados aplicáveis:

- **Normal e foco:** indicar de forma perceptível o elemento ativo e manter a ordem de foco previsível.
- **Desabilitado:** apresentar o estado visual de desativado e não executar a ação associada.
- **Carregamento:** informar a operação em andamento sem permitir ações duplicadas indevidas.
- **Vazio:** explicar quando não há conteúdo e, quando houver ação útil, indicar como prosseguir.
- **Erro ou validação:** identificar o campo ou a operação afetada, explicar o problema em português e orientar a correção sem apagar dados digitados.
- **Sucesso:** confirmar a conclusão de uma ação quando o resultado não for evidente por si só.

Use feedback nativo ou componentes existentes antes de criar mecanismos paralelos. Animações devem ser breves, apoiar a compreensão da interação e não ser o único meio de comunicar mudanças de estado.

## 6. Acessibilidade

- Forneça rótulos acessíveis para controles e imagens com significado; elementos decorativos não devem adicionar ruído à navegação por leitor de tela.
- Garanta que ações possam ser identificadas e usadas sem depender exclusivamente de cor, posição, gesto complexo ou precisão motora.
- Busque alvos de toque de pelo menos `48dp` por `48dp`, mesmo quando o ícone visível for menor.
- Preserve ordem lógica de leitura e foco, descrições concisas e estados acessíveis para controles customizados.
- Respeite fontes ampliadas e configurações de acessibilidade do Android; evite truncar rótulos ou mensagens necessários para concluir uma ação.
- Quando uma view customizada substituir um controle padrão, valide foco, seleção, estado habilitado e anúncio por serviços de acessibilidade.

## 7. Validação de alterações visuais

Antes de concluir uma alteração de interface:

- Compile o módulo afetado e confira referências a layouts, estilos, cores, dimensões, atributos e drawables.
- Verifique o resultado no preview ou em emulador/dispositivo, incluindo pelo menos uma tela compacta.
- Confira tema noturno para componentes que forneçam variantes `-night`.
- Teste teclado, foco, rolagem, escala de fonte e estados de erro/carregamento aplicáveis ao componente.
- Revise rótulos, contraste, tamanho dos alvos de toque e navegação por leitor de tela nos controles afetados.
- Atualize a documentação do componente quando mudar seus atributos, uso, aparência relevante ou comportamento público.

### Avaliação visual registrada em 2026-10-09

A galeria `:app` foi inspecionada em emulador nos temas claro e escuro. Os campos de entrada, popups de validação, opções do `SpinnerTitle`, conteúdo do `CustomDialog` e teclado numérico mantiveram texto e controles legíveis nos dois temas. Esta verificação visual foi feita na configuração demonstrada pela galeria; não constitui validação de todos os tamanhos de tela, escalas de fonte ou layouts fornecidos por consumidores.

Foram registrados dois pontos pendentes nessa avaliação:

- **`HelpButton` / `HelpDialog`:** a ação “Ok” usava `colorPrimary`, que permanecia azul escuro no modo noturno. A implementação agora usa `colorFocus`, com variantes para os dois temas; o contraste da ação foi conferido em emulador no claro e no escuro.
- **`CDialog`:** uma mensagem longa aparecia cortada no alerta circular de tamanho `MEDIUM` observado no emulador. A mensagem agora fica numa área rolável dentro do diálogo, mantendo o ícone e a barra de progresso; uma mensagem de teste longa foi rolada manualmente no alerta oval `MEDIUM` em tema claro. Ainda falta validar conteúdo extenso nos demais tamanhos/formatos e no tema escuro.

### Melhorias subsequentes de ciclo de vida e acessibilidade

- `ProgressIndeterminate` e a barra de progresso do `CDialog` agora atualizam views no thread principal e removem callbacks pendentes ao fechar.
- `RecyclerViewButton` mantém a lista por instância, trata adapter nulo e faz `notifyDataSetChanged()` notificar o adapter antes de atualizar o estado vazio.
- O botão de ajuda e o botão de retorno ao topo têm descrições acessíveis; os alvos de toque relevantes têm pelo menos 48dp. O estado vazio da lista é anunciado como região dinâmica.
- O `HelpDialog` foi aberto no emulador nos dois temas; a ação ficou legível e o ícone recebeu descrição acessível. Uma mensagem longa no `CDialog` foi rolada no emulador e também está exposta como texto integral na hierarquia de acessibilidade. Ainda faltam testes em emulador para encerramento de animações/progresso e uso simultâneo de múltiplas listas.

### Refinamento visual dos campos e superfícies

- As dimensões tipográficas compartilhadas dos campos e labels foram alinhadas entre as variantes de densidade (`16sp` para conteúdo e `14sp` para labels); padding e cantos dos campos também foram uniformizados.
- Campos e spinners passaram a usar superfícies e contornos semânticos, com bordas de foco mais evidentes. Labels, espaçamento e tipografia de descrições foram refinados, e diálogos passaram a ter contornos mais leves.
- O campo habilitado no estado normal e sem foco mantém fundo branco no tema claro, como antes da modernização; o tema escuro continua usando sua superfície variante.
- A seta sobreposta do `SpinnerTitle` usa a cor semântica de conteúdo da superfície para permanecer visível em temas claro e escuro.
- A galeria foi conferida no emulador nos dois temas; os campos, seus labels e o spinner visíveis na tela inicial acompanharam as paletas. Essa conferência não cobre todos os componentes, escalas de fonte ou tamanhos de tela.

## 8. Pontos pendentes de definição

Os itens abaixo exigem validação do responsável pelo produto e não devem ser inferidos dos recursos atuais:

- paleta e tokens visuais oficiais;
- tipografia, escala de títulos e espaçamentos padrão;
- cobertura obrigatória de temas claro e escuro;
- dispositivos, orientações e tamanhos de tela oficialmente suportados;
- critérios de acessibilidade e processo formal de revisão;
- regras de animação e experiência visual específicas do produto.
