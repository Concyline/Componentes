# Changelog

> ⚠️ **REGRA OBRIGATÓRIA PARA AGENTES DE IA**
>
> Todo agente de IA que modificar este projeto deve registrar neste arquivo as alterações relevantes realizadas.
>
> O registro deve ser criado após uma alteração concluída e validada, contendo contexto suficiente para que outros agentes compreendam:
>
> - O que foi alterado.
> - Por que foi alterado.
> - Quais componentes foram afetados.
> - Quais cuidados devem ser considerados em futuras alterações.
>
> Este documento é uma fonte histórica oficial do projeto.
>
> **Propósito como scaffold genérico:** Este arquivo serve como histórico evolutivo de qualquer projeto novo. Ele não fixa decisões técnicas permanentes; ao contrário, ele registra o que foi validado, permitindo que agentes e desenvolvedores acompanhem o crescimento da base documental e do código.

---

# Objetivo

Este arquivo documenta a evolução técnica do projeto, mantendo histórico das alterações realizadas em:

- Código-fonte.
- Estrutura arquitetural.
- Banco de dados.
- APIs.
- Componentes frontend.
- Configurações.
- Dependências.
- Regras de negócio.

O Changelog deve auxiliar desenvolvedores e agentes de IA na manutenção segura do sistema.

---

# Padrão de Versionamento

Este projeto utiliza:

- Keep a Changelog
- Semantic Versioning

Formato:


Todas as alterações significativas neste projeto serão documentadas neste arquivo. O formato é baseado em [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), e este projeto adota Versionamento Semântico.

## [1.0.29] - 2026-10-09

### Added

- Publicado no JitPack o artefato `com.github.Concyline:Componentes:1.0.29`, com AAR, POM e sources JAR.

### Changed

- Incrementada a versão Maven da biblioteca de `1.0.28` para `1.0.29`, conforme a regra de release.
- Atualizado o Android Gradle Plugin de `9.0.0` para `9.4.1` e o Gradle Wrapper de `9.1.0` para `9.6.0` para o build do release.

### Validation

- `:componentes:assembleRelease` e `:app:assembleDebug` concluíram localmente com sucesso usando o JBR 25 do Android Studio.
- `:componentes:testDebugUnitTest` retornou `NO-SOURCE`; não havia testes unitários da biblioteca para executar.
- Build JitPack da tag `1.0.29` concluído com `BUILD SUCCESSFUL` no Oracle JDK `17.0.12` e Gradle `9.6.0`.
- Commit `935babf` e tag remota `1.0.29` confirmados em `origin`. O commit incluiu somente os três arquivos de configuração do release.

## [Unreleased]

### Added

- Transformada a tela inicial do app de demonstração em galeria vertical e interativa das views, listas, gestos, progresso e diálogos da biblioteca `:componentes`, com recursos de texto dedicados.
- Atualizados `ARCHITECTURE.md` e `CATALOGO_COMPONENTES.md` para apontar o app como catálogo executável dos componentes.
- Documentada em `DEPLOYMENT.md` a regra de incrementar em 1 o último segmento numérico de `publishing.release.version` a cada novo deploy/release da biblioteca.
- Criados `CATALOGO_COMPONENTES.md` e `MODULOS.md` com inventário dos 48 arquivos Java da biblioteca, atributos XML, APIs observadas, dependências e limitações dos módulos Android.
- Preenchido `DEPLOYMENT.md` com os builds locais da biblioteca/app, a configuração de publicação, a regra de versão e as evidências do release JitPack `1.0.29`.
- Documentada em `ARCHITECTURE.md` a arquitetura observada dos módulos Android, suas dependências e as pendências que ainda precisam de confirmação.
- Preenchido `SETUP.md` com os pré-requisitos observados e instruções de clonagem, importação e build do projeto Android.
- Completado `UI_GUIDELINES.md` com orientações de interface Android, acessibilidade e validação, distinguindo padrões observados de decisões visuais pendentes.
- Criado `POPULACAO_CHECKLIST.md` com o fluxo para transformar o scaffold documental em documentação oficial de um projeto real.
- Adicionado o checklist ao índice e à árvore de documentação do `AGENTS.md`.
- Criados templates para funcionalidades, planos, erros, incidentes, lições aprendidas, componentes compartilhados e documentação técnica de módulos.
- Mantidos os `README.md` como guias operacionais de cada diretório, com links para os templates correspondentes.
- Criada `KNOWLEDGE/REFERENCE/` para armazenar projetos e artefatos técnicos autorizados como fonte auxiliar de consulta e treinamento operacional dos agents.
- Criada `KNOWLEDGE/REFERENCE/PROJECTS/` como local isolado para armazenar os projetos de referência.
- Documentado o fluxo completo de inclusão, sanitização, classificação, catalogação e consulta dos projetos de referência.
- Adicionados modelos `PROJECTS/TEMPLATE.md` e `PROJECTS/REFERENCE_METADATA_TEMPLATE.yml` para padronizar o cadastro de cada projeto.
- Incluído o cadastro de projetos de referência no `POPULACAO_CHECKLIST.md` e na tabela de documentação por tipo de tarefa do `AGENTS.md`.
- Criado `KNOWLEDGE/REFERENCE/TRAINING.md` com o ciclo de treinamento operacional por consulta, comparação, adaptação, validação e registro.

### Changed

- Fixada em `48dp` a altura dos campos de entrada padrão, de data, financeiro, autocomplete e busca, usando a dimensão comum de alvo de toque para evitar variações visuais entre componentes.
- Organizadas as paletas clara/escura da biblioteca com tokens semânticos para superfícies, textos, bordas, foco, desabilitado e cores de estado, mantendo nomes de recursos legados e sem impor um tema global ao app consumidor.
- Aplicados os tokens em campos, spinners, labels, popups, diálogos, progresso e ícones; campos desabilitados também recebem texto apropriado ao estado. Removidos hardcodes de cores de interface e atualizados os padrões de erro, foco e progresso para acompanhar o tema, sem alterar dimensões, formas ou interação dos componentes.
- Tornada rolável a mensagem do `CDialog` sem alterar a dimensão da janela; corrigido o contraste da ação “Ok” do `HelpDialog` pelo token temático `colorFocus`.
- Movida a animação multicolorida de `ProgressIndeterminate` e a atualização da barra do `CDialog` para callbacks canceláveis no thread principal.
- Removido o estado estático compartilhado de `RecyclerViewButton`; adapter nulo e notificações agora atualizam de forma segura o estado vazio, e descrições/alvos acessíveis foram adicionados aos controles afetados.
- Revisadas as diretrizes e descrições arquiteturais do suporte a temas para registrar os tokens e os limites de validação atuais.
- Refinadas tipografia, espaçamento, superfícies, contornos e estados de foco dos campos, spinners, labels e diálogos; alinhadas as dimensões qualificadas por densidade e corrigida a cor da seta sobreposta do spinner para os dois temas.
- Restaurado para branco o fundo dos campos habilitados sem foco no tema claro, preservando a superfície variante no tema escuro.
- Centralizado verticalmente o ícone de validação e os ícones laterais de `EditTextTitle` em relação ao campo de entrada; aplicado um pequeno ajuste para cima no ícone de validação.
- Preservadas as cores próprias dos ícones laterais de `EditTextTitle` por padrão; a cor personalizada `coricon` continua aplicada quando informada. O ícone de validação mantém sua cor semântica de foco e fica vermelho durante o erro.
- Padronizada a amostra avulsa de `CurrencyEditText` na galeria com o fundo, espaçamento e tipografia usados pelos demais campos.
- Centralizados os ícones de data e hora do `EditTextCalendar` verticalmente em relação ao campo, e não à legenda.
- Reforçada a distinção entre template genérico, hipótese e decisão oficial.
- Corrigidas pequenas inconsistências textuais nos documentos de conhecimento e aprendizado.
- Melhorado o `AGENTS.md` com hierarquia de prioridades, níveis de autonomia, protocolo de evidências, validação adaptativa, formato de saída, regras de débito técnico e referências de ferramentas mais genéricas.

### Validation

- `:componentes:assembleDebug`, `:app:assembleDebug` e `:componentes:assembleRelease` concluíram com sucesso; `:componentes:testDebugUnitTest` não possui testes (`NO-SOURCE`).
- Galeria instalada e iniciada no emulador nos temas claro e escuro; as superfícies e textos dos componentes acompanharam o modo do sistema sem alterar suas dimensões ou formas.
- Avaliados visualmente no emulador popups de validação, spinner, `CustomDialog`, `CDialog`, `HelpDialog` e teclado numérico nos temas claro e escuro. Campos, spinner, popup, `CustomDialog` e teclado permaneceram legíveis; foram documentados como pendências o contraste da ação “Ok” de `HelpDialog` no escuro e o corte de mensagens longas no alerta circular `MEDIUM` de `CDialog` em ambos os temas. Os dois pontos estão registrados em `UI_GUIDELINES.md` e no catálogo; não foram corrigidos nesta avaliação.
- Após essas correções, os builds debug da biblioteca/app e release da biblioteca concluíram novamente; `:componentes:testDebugUnitTest` continua `NO-SOURCE`. O `HelpDialog` foi conferido no emulador claro/escuro e a ação “Ok” teve contraste legível; uma mensagem longa do `CDialog` foi rolada no alerta oval `MEDIUM` em tema claro, e o texto integral foi exposto na hierarquia de acessibilidade. O `CDialog` também foi aberto no tema escuro. Animação multicolorida após dismiss e cenários com múltiplas listas ainda não foram validados visualmente.
- Após o refinamento visual, `:componentes:assembleDebug`, `:app:assembleDebug` e `:componentes:assembleRelease` concluíram com sucesso; `:componentes:testDebugUnitTest` continua `NO-SOURCE`. Campos, labels e spinner da tela inicial da galeria foram inspecionados nos temas claro e escuro.
- `:componentes:assembleDebug` e `:app:assembleDebug` concluíram com sucesso após o ajuste de alinhamento; `git diff --check` passou e o ícone foi conferido no emulador.
- `:app:assembleDebug` e `:app:installDebug` concluíram com sucesso após restaurar o fundo branco dos campos sem foco; a galeria foi iniciada no emulador Android 16.

---