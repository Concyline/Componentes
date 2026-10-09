# Arquitetura do Projeto

> **Status:** descrição do estado identificado nos arquivos do repositório em 2026-10-09. Os itens marcados como **PENDENTE** não devem ser tratados como decisões oficiais.
>
> **Escopo:** este projeto é uma biblioteca Android de componentes de interface, acompanhada por um aplicativo Android de demonstração. Não há evidência, nos módulos e configurações consultados, de backend, banco de dados ou API próprios.

## 1. Visão geral

O repositório usa Gradle com dois módulos Android:

```text
Aplicativo de demonstração (:app)
              │ depende de
              ▼
Biblioteca de componentes (:componentes)
```

O módulo `:componentes` concentra views customizadas, diálogos, adaptadores, utilitários, recursos visuais e fontes reutilizáveis. O módulo `:app` é um aplicativo Android executável que consome a biblioteca e serve como demonstração manual dos componentes.

A arquitetura observada é modular e centrada na plataforma Android. Não está organizado como uma aplicação cliente-servidor nem como uma arquitetura de backend em camadas.

## 2. Módulos e responsabilidades

| Módulo | Caminho | Responsabilidade |
|---|---|---|
| `:componentes` | `componentes/` | Biblioteca Android reutilizável. Expõe componentes de UI e recursos para aplicativos consumidores. |
| `:app` | `app/` | Aplicativo de demonstração, com atividade inicial, layouts e exemplos de consumo da biblioteca. |

### 2.1 Biblioteca `:componentes`

O código Java está em `componentes/src/main/java/br/com/componentes/`. As classes do pacote principal incluem componentes visuais como `EditTextTitle`, `EditTextCalendar`, `SpinnerTitle`, `CDialog`, `ProgressButton`, `GeometricProgressView` e `ZoomFrameImageView`.

Os subpacotes agrupam implementações auxiliares:

| Pacote | Conteúdo observado |
|---|---|
| `br.com.componentes.baseadaper` | Adaptador e listener para interações de itens em listas. O nome do pacote mantém a grafia existente no código. |
| `br.com.componentes.currency` | Campo de entrada relacionado a valores monetários. |
| `br.com.componentes.dotloader` | Classes auxiliares de animação do indicador de carregamento. |
| `br.com.componentes.extras` | Tipos e opções auxiliares para diálogos e apresentação. |
| `br.com.componentes.geometricprogress` | Tipos auxiliares para o indicador de progresso geométrico. |
| `br.com.componentes.Util` | Máscaras, validações de CPF/CNPJ e utilitários. A capitalização corresponde ao pacote existente. |
| `br.com.componentes.zoom` | Modelos, transições e operações auxiliares para componentes de zoom. |

Os recursos Android da biblioteca ficam em `componentes/src/main/res/`, incluindo layouts, animações, drawables, temas, dimensões e atributos. Fontes incorporadas ficam em `componentes/src/main/assets/fonts/`.

### 2.2 Aplicativo `:app`

O aplicativo tem `MainActivity` como atividade inicial e usa View Binding. Seu código e seus layouts estão em `app/src/main/`. A atividade demonstra componentes da biblioteca, incluindo campos de entrada e o adaptador de lista.

O aplicativo é uma superfície de demonstração; seu código não define, por si só, funcionalidades ou regras de negócio para a biblioteca.

## 3. Dependências entre módulos e fluxo

A dependência explícita entre os módulos é unidirecional: `:app` depende de `:componentes`, declarada em `app/build.gradle`. A biblioteca não declara dependência do aplicativo.

O fluxo de uso esperado, conforme essa estrutura, é:

1. Um aplicativo Android inclui a biblioteca como dependência.
2. O aplicativo instancia os componentes, diretamente ou por layouts e atributos XML.
3. Os componentes usam APIs Android/AndroidX e recursos empacotados na própria biblioteca.

Não foram identificados módulos de serviço, API, persistência de dados, integrações de rede ou processos em segundo plano nas configurações e fontes examinadas. Se forem adicionados, sua arquitetura e seus contratos deverão ser documentados antes de serem tratados como parte do desenho vigente.

## 4. Stack configurada

Os valores abaixo foram observados nos arquivos de build; representam configuração atual do repositório, não uma política de compatibilidade além do que esses arquivos declaram.

| Área | Configuração observada | Fonte |
|---|---|---|
| Plataforma | Android | `settings.gradle`, manifests e scripts Gradle |
| Linguagem | Java | Módulos `:app` e `:componentes` |
| Build | Scripts Gradle Groovy, Gradle Wrapper 9.6.0 e Android Gradle Plugin 9.4.1 | Scripts `*.gradle`, `gradle/wrapper/gradle-wrapper.properties` e `gradle/libs.versions.toml` |
| SDK de compilação | `compileSdk 36` nos dois módulos | `app/build.gradle`, `componentes/build.gradle` |
| SDK mínimo | `minSdk 23` nos dois módulos | `app/build.gradle`, `componentes/build.gradle` |
| SDK alvo | `targetSdk 36` no aplicativo de demonstração | `app/build.gradle` |
| Compatibilidade Java | Java 11 no aplicativo; Java 17 na biblioteca | `compileOptions` dos módulos |
| JDK para JitPack | JDK 17 | `jitpack.yml` |
| Repositórios de dependências | Google Maven e Maven Central | `settings.gradle` |
| Catálogo de versões | Gradle Version Catalog | `gradle/libs.versions.toml` |
| Testes declarados | JUnit, AndroidX Test JUnit e Espresso | `gradle/libs.versions.toml` e dependências dos módulos |

### 4.1 Dependências principais

As versões são centralizadas em `gradle/libs.versions.toml`.

| Módulo | Dependências de produção declaradas |
|---|---|
| `:componentes` | AndroidX AppCompat 1.7.1, Material Components 1.12.0 e SwipeRefreshLayout 1.1.0 |
| `:app` | AndroidX AppCompat 1.7.1, Material Components 1.12.0, ConstraintLayout 2.2.1, Navigation Fragment/UI 2.9.3 e `:componentes` |

As dependências de teste declaradas são JUnit 4, AndroidX Test JUnit e Espresso. A presença dessas dependências não confirma cobertura: não foram encontrados diretórios de testes `src/test` ou `src/androidTest` nos módulos durante esta análise.

## 5. Recursos visuais e interface

Os componentes de UI são implementados em Java, incluindo subclasses de views Android e layouts compostos. Layouts XML e recursos da biblioteca ficam sob `componentes/src/main/res/`; o aplicativo de demonstração mantém seus próprios layouts e recursos sob `app/src/main/res/`.

A biblioteca possui recursos alternativos para tema noturno em diretórios como `drawable-night` e `values-night`. Isso comprova a existência de recursos específicos para modo noturno, mas não define, por si só, uma política completa de temas ou de acessibilidade.

Não foi identificada uma especificação de design aprovada com tokens, tipografia ou regras completas de experiência. Essas decisões permanecem pendentes de documentação e validação do responsável pelo projeto.

## 6. Build, testes e publicação

Comandos disponíveis pelo Gradle Wrapper no Windows:

```powershell
.\gradlew.bat :componentes:assembleRelease
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :componentes:testDebugUnitTest
```

O último comando executa os testes unitários da biblioteca, se existirem. A configuração declara a publicação de um artefato Maven pela biblioteca:

| Campo | Valor configurado |
|---|---|
| `groupId` | `com.github.Concyline` |
| `artifactId` | `Componentes` |
| `version` | `1.0.28` |
| JDK indicado para JitPack | 17 |

Essa configuração não comprova que a versão foi publicada nem documenta o processo de release. CI, aprovação de releases, publicação efetiva, suporte a consumidores e política de versionamento são **PENDENTES**.

## 7. Persistência, rede e segurança

Não foram identificadas dependências ou declarações de banco de dados, ORM, autenticação, API de backend ou cliente HTTP nos arquivos de configuração e fontes consultados. Os manifests examinados também não declaram permissões de rede.

Portanto, esses temas não são descritos como subsistemas existentes nesta arquitetura. Se uma funcionalidade futura introduzir acesso a dados, rede, credenciais ou permissões, seus requisitos de segurança e limites arquiteturais deverão ser avaliados e registrados antes da implementação.

## 8. Testes e qualidade

Os scripts declaram runners e dependências para testes unitários e instrumentados. Não foram localizados arquivos ou diretórios de testes nos módulos durante esta análise; a cobertura automatizada efetiva permanece **PENDENTE** de confirmação.

Os comandos de build e teste listados nesta documentação refletem tarefas padrão do Android Gradle Plugin. Eles não foram executados como parte do levantamento arquitetural.

## 9. Decisões arquiteturais e pendências

As configurações atuais demonstram a estrutura e as tecnologias em uso, mas não registram necessariamente o motivo de sua adoção. Nenhuma decisão arquitetural formal ou registro ADR foi identificado nos documentos consultados.

Pontos que precisam de validação humana antes de serem registrados como decisões oficiais:

- objetivo, público consumidor e limites de responsabilidade da biblioteca;
- versões de Android efetivamente suportadas e política de compatibilidade;
- processo oficial de publicação e versionamento, inclusive o uso de JitPack;
- política de testes e cobertura esperada;
- diretrizes visuais, acessibilidade e suporte a temas;
- existência de requisitos de CI ou de release fora dos arquivos consultados.

## 10. Atualização da arquitetura

Atualize este documento quando houver alteração em módulos, dependências entre eles, SDKs, linguagem, dependências de produção, interfaces públicas, recursos compartilhados ou processo de publicação. Registre separadamente fatos observáveis, decisões aprovadas e itens ainda pendentes; não converta exemplos ou configurações encontradas em políticas sem validação.
