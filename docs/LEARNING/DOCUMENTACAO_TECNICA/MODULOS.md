# Documentação Técnica dos Módulos

**Status:** `CATALOG`
**Última atualização:** `2026-10-09`
**Fonte:** arquivos Gradle, manifests, código e recursos presentes no repositório.

O repositório contém dois módulos Android e uma dependência de projeto entre eles. O inventário das classes reutilizáveis e dos atributos XML fica em [`CATALOGO_COMPONENTES.md`](../COMPONENTS/CATALOGO_COMPONENTES.md).

## 1. Visão geral e dependências

```text
settings.gradle
├── :componentes  (Android Library / AAR)
└── :app          (Android Application)
      └────────── depende de :componentes
```

| Módulo | Caminho | Plugin/tipo | Responsabilidade |
|---|---|---|---|
| `:componentes` | `componentes/` | `com.android.library` | Biblioteca de componentes de interface, adaptadores, utilitários Java e recursos Android reutilizáveis. |
| `:app` | `app/` | `com.android.application` | Aplicativo executável de demonstração e consumidor local da biblioteca. |

A relação é unidirecional: `app/build.gradle` declara `implementation project(':componentes')`; a biblioteca não depende de `:app`. O projeto não declara módulos próprios de backend, persistência, API ou integração de rede.

## 2. Módulo `:componentes`

### Objetivo e conteúdo

Disponibiliza views compostas e customizadas, diálogos, suporte a listas, validadores, máscaras, animações e recursos visuais/fontes. O namespace Android é `br.com.componentes`.

| Caminho | Conteúdo |
|---|---|
| `componentes/src/main/java/br/com/componentes/` | Views e componentes de alto nível (entradas, diálogo, imagem, listas e progresso). |
| `componentes/src/main/java/br/com/componentes/Util/` | Máscaras, tipos de entrada, formatação e validação de CPF/CNPJ. |
| `componentes/src/main/java/br/com/componentes/baseadaper/` | `BaseAdapter` e callbacks de item; a grafia `baseadaper` é a usada no pacote público atual. |
| `componentes/src/main/java/br/com/componentes/currency/` | Campo `CurrencyEditText`. |
| `componentes/src/main/java/br/com/componentes/dotloader/` | Implementação auxiliar do indicador de pontos. |
| `componentes/src/main/java/br/com/componentes/extras/` | Enums de configuração de diálogos. |
| `componentes/src/main/java/br/com/componentes/geometricprogress/` | Tipos auxiliares do indicador geométrico. |
| `componentes/src/main/java/br/com/componentes/zoom/` | Modelo e geração de transições de zoom. |
| `componentes/src/main/res/` | Layouts, atributos, cores, dimensões, drawables, animações e temas da biblioteca. |
| `componentes/src/main/assets/fonts/` | Fontes incorporadas, carregadas por alguns componentes. |

### Build e dependências

- `compileSdk 36`, `minSdk 23`, Java source/target 17.
- Android Gradle Plugin via alias `libs.plugins.android.library`.
- Dependências de produção: AppCompat 1.7.1, Material Components 1.12.0 e SwipeRefreshLayout 1.1.0.
- Dependências de teste declaradas: JUnit 4, AndroidX Test JUnit e Espresso; não foram localizados testes-fonte durante o levantamento.
- `release` declara `minifyEnabled false`.

### Contrato de consumo e riscos de mudança

Os tipos Java públicos, pacotes e atributos XML são interfaces potenciais para aplicativos consumidores. Antes de mudar assinaturas, recursos, valores de enums ou nomes, procure usos dentro e fora do repositório e avalie compatibilidade binária/fonte. Não há política documentada de versionamento/depreciação por API.

O script Gradle declara uma publicação Maven com `groupId=com.github.Concyline`, `artifactId=Componentes` e `version=1.0.28`; `jitpack.yml` indica JDK 17. Isso descreve configuração de publicação, não confirma versão liberada, processo de aprovação ou disponibilidade do artefato.

## 3. Módulo `:app`

### Objetivo e fluxo

Aplicativo Android de demonstração. O manifest declara `MainActivity` como launcher. A tela usa `ActivityMainBinding` (View Binding), layouts XML e componentes de `:componentes`. O código observado configura `EditTextTitleAutoComplete` com uma lista local de cidades e configura um `RecyclerView`; a classe `Cidade` é um modelo simples com `nome` e `uf`.

O app é exemplo de integração local, não uma especificação funcional da biblioteca, catálogo completo de exemplos, aplicação de produção ou fonte de regras de negócio.

### Build e dependências

- `applicationId`/namespace: `br.com.componentes`.
- `compileSdk 36`, `minSdk 23`, `targetSdk 36`.
- Java source/target 11 e View Binding habilitado.
- Dependências declaradas: AppCompat 1.7.1, Material Components 1.12.0, ConstraintLayout 2.2.1, Navigation Fragment/UI 2.9.3 e `:componentes`.
- Testes declarados: JUnit, AndroidX Test JUnit e Espresso; não foram localizados testes-fonte durante o levantamento.

## 4. Grafo de recursos e dependências técnicas

Ambos os módulos usam `namespace br.com.componentes`; a dependência é resolvida como módulo Android pelo Gradle. Os scripts definem `google()` e `mavenCentral()` como repositórios de dependências, e as versões ficam em `gradle/libs.versions.toml`.

`settings.gradle` é a fonte de módulos incluídos. O catálogo de versões, `app/build.gradle`, `componentes/build.gradle`, manifests e diretórios `src/main` são fontes a revisar ao atualizar esta documentação.

## 5. Build e validação dos módulos

Execute na raiz do repositório:

```powershell
.\gradlew.bat :componentes:assembleRelease
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :componentes:testDebugUnitTest
```

O app pode ser instalado em um dispositivo/emulador conectado com `.\gradlew.bat :app:installDebug`. Os comandos são tarefas Gradle compatíveis com a configuração atual; a existência de diretórios de saída ou dependências de teste não constitui evidência de que o build/teste foi executado ou aprovado.

## 6. Itens pendentes

- Finalidade oficial, consumidores e escopo de produto da biblioteca.
- Política de compatibilidade de API e Android, além dos valores `minSdk`/`targetSdk` definidos nos scripts.
- Processo real de release/publicação, CI, assinatura e suporte a versões.
- Cobertura, localização e política dos testes unitários/instrumentados.
- Se `:app` deve permanecer um app de demonstração e quais exemplos devem ser mantidos.
- Requisitos de acessibilidade, suporte de tema e validação visual sistemática.

Não trate esses itens como decisões até confirmação pela equipe.

## 7. Atualização

Atualize esta página quando módulos, responsabilidades, configurações de build, dependências ou relações entre módulos mudarem. Atualize o inventário de views e atributos em [`CATALOGO_COMPONENTES.md`](../COMPONENTS/CATALOGO_COMPONENTES.md) quando o contrato público da biblioteca mudar.
