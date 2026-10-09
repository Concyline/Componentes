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

- Reforçada a distinção entre template genérico, hipótese e decisão oficial.
- Corrigidas pequenas inconsistências textuais nos documentos de conhecimento e aprendizado.
- Melhorado o `AGENTS.md` com hierarquia de prioridades, níveis de autonomia, protocolo de evidências, validação adaptativa, formato de saída, regras de débito técnico e referências de ferramentas mais genéricas.

---