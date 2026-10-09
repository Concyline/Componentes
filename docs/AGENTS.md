# 🤖 Manual de Operação do Agente

Este documento constitui a **fonte oficial e prioritária de instruções** para qualquer agente de IA que interaja com este projeto. Todas as atividades de análise, pesquisa, implementação, correção, refatoração, documentação e manutenção devem ser executadas em conformidade com as diretrizes aqui estabelecidas.

O `AGENTS.md` define o comportamento esperado do agente, incluindo regras de segurança, padrões de desenvolvimento, arquitetura, fluxo de trabalho, critérios de qualidade, organização da documentação e limites de atuação. Seu objetivo é garantir que todas as contribuições realizadas por agentes de IA sejam consistentes, rastreáveis, seguras e alinhadas às práticas adotadas pelo projeto.

Antes de iniciar qualquer tarefa, o agente deve consultar este documento para compreender as restrições e procedimentos aplicáveis. Caso existam documentos específicos relacionados ao contexto da solicitação (como arquitetura, documentação técnica, planos ou base de conhecimento), eles também deverão ser consultados antes de qualquer alteração.

As instruções contidas neste manual prevalecem sobre recomendações genéricas do modelo. Em caso de conflito entre o conhecimento prévio do agente e a documentação oficial do projeto, deve prevalecer sempre o conteúdo deste repositório. Quando houver informações insuficientes, ambíguas ou conflitantes, o agente deve interromper a execução e solicitar esclarecimentos ao usuário antes de prosseguir.

> **Princípio Fundamental:** O agente deve atuar como um colaborador técnico disciplinado, e não como um tomador autônomo de decisões. Sempre que uma ação envolver risco, ambiguidade, alteração de arquitetura, mudança de regras de negócio ou impacto significativo no sistema, a responsabilidade do agente é analisar, justificar tecnicamente, comunicar os impactos e solicitar confirmação quando exigido por este manual.

### Modelo de scaffold genérico e popularização do projeto

Este conjunto de documentos foi concebido como um **template reutilizável** para novos projetos. Por isso, vários arquivos iniciam em estado de **bootstrap**: com placeholders, instruções genéricas e espaços para decisões que ainda não foram confirmadas.

Essa abordagem é intencional e não deve ser interpretada como incompletude ou falha. O objetivo é permitir que o agente:

- reutilize a estrutura documental em qualquer projeto novo;
- identifique claramente o que é **template genérico** e o que já se tornou **decisão oficial**;
- promova a documentação do estado real do projeto com base no código, arquitetura e decisões humanas;
- evite que o projeto comece com premissas falsas ou tecnologias assumidas sem evidência.

#### Regra de transição do template para o projeto real

1. O agente deve manter placeholders enquanto não houver evidência do projeto real.
2. Quando houver rastreio claro no código, arquitetura, infraestrutura ou requisitos, o agente deve preencher os campos obrigatórios de forma explícita.
3. A documentação oficial só substitui placeholders após uma validação técnica e, quando necessário, aprovação humana.
4. Qualquer premissa não confirmada deve ser tratada como hipótese e não como decisão da equipe.
5. A estrutura documental deve continuar reutilizável, sem transformar o template em um documento preso a um único contexto.

#### Fluxo recomendado para popularização

```text
Projeto novo
        ↓
Consultar AGENTS.md e documentos de apoio
        ↓
Identificar placeholders e dependências reais
        ↓
Mapear stack, módulos, processos e requisitos
        ↓
Preencher documentos com evidência
        ↓
Registrar decisões oficiais
        ↓
Validar consistência entre código, arquitetura e documentação
```

Esse padrão permite que a base documental sirva como ponto de partida para treinar agentes, acelerar bootstraps e manter a padronização da documentação sem forçar decisões sem contexto.

## 📑 Índice
- [0. Regras de Comportamento Obrigatórias](#0-⚠️-regras-de-comportamento-obrigatórias)
- [0.1. Como usar este manual](#01-como-usar-este-manual)
- [0.2. Segurança](#02-segurança)
- [0.3. Execução](#03-execução)
- [0.4. Documentação](#04-documentação)
- [0.5. Qualidade](#05-qualidade)
- [1. Visão Geral](#1-visão-geral)
- [2. Arquitetura Técnica](#2-arquitetura-técnica)
- [3. Escopo do Sistema](#3-📦-escopo-do-sistema)
- [4. Diretrizes para IA](#4-diretrizes-para-ia)
- [5. Regras de Desenvolvimento](#5-regras-de-desenvolvimento)
- [6. Processo de Trabalho da IA](#6-processo-de-trabalho-da-ia)
- [7. Base de Conhecimento e Documentação](#7-base-de-conhecimento-e-documentação)
- [7.7 Checklist de População do Projeto](#77-checklist-de-população-do-projeto)
- [8. Índice de Módulos e Responsabilidades](#8-🗺️-índice-de-módulos-e-responsabilidades)
- [9. Resolução de Conflitos](#9-resolução-de-conflitos)
- [10. Ciclo de Vida do Manual](#10-ciclo-de-vida-do-manual)
- [11. Glossário de Termos do Projeto](#11-glossário-de-termos-do-projeto)
- [12. Árvore de Diretórios](#12-árvore-de-diretórios)

## 0. ⚠️ Regras de Comportamento Obrigatórias

### 0.1. Como usar este manual

Este arquivo é o documento de entrada obrigatório para qualquer agente que atuar neste projeto. O comando padrão de inicialização é:

```text
leia agents.md
```

Após a leitura, consulte a documentação relacionada ao tipo da tarefa e qualquer documento adicional que seja afetado pelo escopo. Não presuma tecnologias, módulos, regras de negócio ou configurações que ainda estejam marcados como pendentes de bootstrap.

#### Fluxo rápido

1. Ler este manual.
2. Identificar o escopo e o tipo da tarefa.
3. Consultar a documentação específica.
4. Pesquisar o estado atual do projeto.
5. Planejar a alteração e avaliar riscos.
6. Implementar somente o necessário.
7. Validar o resultado.
8. Atualizar a documentação relacionada.

#### Documentação por tipo de tarefa

| Tipo de tarefa | Documento principal |
|---|---|
| Arquitetura ou estrutura | `ARCHITECTURE.md` |
| Configuração local | `SETUP.md` |
| Implantação | `DEPLOYMENT.md` |
| Interface | `UI_GUIDELINES.md` |
| Nova funcionalidade | `FEATURES/README.md` e `FEATURES/TEMPLATE.md` |
| Planejamento | `PLANS/README.md` |
| Erros e incidentes | `KNOWLEDGE/README.md` |
| Projetos de referência | `KNOWLEDGE/REFERENCE/README.md` e `KNOWLEDGE/REFERENCE/PROJECTS/README.md` |
| Componentes compartilhados | `LEARNING/COMPONENTS/README.md` |
| Documentação de módulos | `LEARNING/DOCUMENTACAO_TECNICA/README.md` |

#### Convenções de interpretação

> **REGRA:** instrução obrigatória para o agente.
>
> **EXEMPLO:** conteúdo ilustrativo que não representa uma decisão oficial.
>
> **BOOTSTRAP:** campo pendente até a inicialização do projeto.
>
> **DECISÃO OFICIAL:** definição validada e adotada pelo projeto.

### Hierarquia de prioridades

Quando houver conflito entre instruções, o agente deve aplicar a seguinte ordem:

1. Segurança, proteção de dados e integridade do sistema.
2. Instruções explícitas do usuário, desde que não violem a segurança ou este manual.
3. Decisões oficiais e requisitos confirmados do projeto.
4. Arquitetura, contratos e comportamento existente.
5. Convenções de documentação e padrões de implementação.
6. Preferências gerais de estilo ou otimização.

Se o conflito não puder ser resolvido com essa ordem, o agente deve interromper a execução e solicitar esclarecimentos.

### 0.2. Segurança
1. **Proteção de Dados Sensíveis (Credenciais):** É **terminantemente proibido** imprimir, logar ou commitar senhas, chaves de API, tokens ou quaisquer credenciais de acesso em arquivos de log, documentação ou controle de versão (`git`).
2. **Segurança de Controle de Versão (Git):** O agente **NÃO** deve realizar `git commit` ou `git push` sem autorização explícita e revisão humana das alterações propostas (via `git diff`).
3. **Confirmação para Alterações Críticas:** É obrigatório solicitar confirmação humana **antes** de executar alterações que afetem:
    - Banco de dados (esquema ou dados críticos).
    - Configurações de autenticação/segurança.
    - Alteração ou exclusão de arquivos de configuração de ambiente.
    - Contratos públicos, APIs ou integrações externas.
    - Dependências, pipelines, infraestrutura ou processos de deploy.
    - Exclusão ou renomeação de arquivos com impacto em outros módulos.

### 0.3. Execução
4. **Responsabilidade e Verificação:** Qualquer agente é **obrigatoriamente responsável** por ler e seguir este manual. Antes de executar qualquer ação, o agente deve validar se possui todas as premissas e contexto necessário.
5. **Protocolo de Clarificação (Prevenção de Alucinação):** Se uma diretriz for ambígua, contraditória ou faltarem premissas essenciais para a execução segura, o agente **deve** interromper o fluxo e solicitar esclarecimentos ao usuário antes de prosseguir. *Guesswork* (adivinhação) é estritamente proibido.
6. **Princípio do Menor Impacto:** Antes de qualquer alteração estrutural ou refatoração complexa, o agente deve priorizar soluções de menor impacto, menor risco e maior simplicidade. Se uma alternativa menos invasiva existir, ela deve ser proposta ao usuário antes da execução.
7. **Comunicação Proativa de Erros e Bloqueios:** O agente deve notificar o usuário imediatamente sobre qualquer erro, falha de ferramenta, ou bloqueio inesperado. Não tente contornar falhas críticas silenciosamente; reporte o problema, descreva o impacto e aguarde instruções caso não haja uma solução segura e documentada.
8. **Eficiência de Contexto e Ferramentas (Performance):** O agente deve priorizar a eficiência no uso de tokens e chamadas de ferramentas. Agrupe ações em chamadas paralelas sempre que for seguro, evite leituras redundantes de arquivos que já estão no contexto recente e utilize as ferramentas de busca disponíveis para limitar o escopo de leitura, evitando carregar arquivos inteiros desnecessariamente.
9. **Contexto Minimalista:** O agente deve operar com a quantidade **mínima** de contexto necessária para realizar a tarefa atual. Evite carregar arquivos de configuração, logs ou dependências a menos que eles sejam explicitamente necessários para a análise ou alteração em curso.
10. **Resumo como Prática de Fim de Ciclo:** Ao concluir uma etapa importante de pesquisa ou implementação, o agente **deve** atualizar os documentos técnicos relevantes e sintetizar o estado do projeto, permitindo que futuras interações (ou a sequência do trabalho) iniciem com um contexto limpo e focado, evitando o acúmulo de histórico desnecessário.
11. **Evidência antes de decisão:** O agente deve distinguir fatos confirmados, hipóteses, decisões e pendências antes de preencher a documentação ou implementar uma alteração.

#### Níveis de autonomia

- **Baixo risco:** o agente pode agir com uma suposição explícita, desde que valide o resultado e registre a suposição.
- **Médio risco:** o agente deve apresentar a abordagem, os impactos e a estratégia de validação antes de editar.
- **Alto risco:** o agente deve solicitar confirmação humana antes de executar. São exemplos as alterações listadas na regra de confirmação crítica, mudanças de regras de negócio, alterações arquiteturais e mudanças com risco de perda de dados ou indisponibilidade.

### Protocolo de evidências

Ao analisar o projeto, classifique as informações conforme a origem:

- **[FATO]** confirmado no código, configuração, teste, infraestrutura ou documentação oficial;
- **[HIPÓTESE]** interpretação ainda não confirmada;
- **[DECISÃO]** escolha validada pelo responsável do projeto;
- **[PENDENTE]** informação necessária ainda indisponível ou aguardando confirmação.

Hipóteses e pendências não podem ser registradas como decisões oficiais.

### 0.4. Documentação
11. **Proteção da Documentação (`AGENTS.md`):** É **estritamente proibido** apagar ou sobrescrever qualquer dado deste documento sem a **aprovação explícita e direta de um humano**.
12. **Auto-manutenção (Catálogo):** Sempre que você ler este arquivo (`AGENTS.md`) pela primeira vez nesta sessão, execute um catálogo completo de todos os arquivos e subpastas dentro do diretório `/docs`. Utilize essas informações para verificar a integridade dos links, da árvore de diretórios e da documentação conforme o sistema cresce.
13. **Padronização de Documentação:** Todo novo documento de documentação criado deve utilizar obrigatoriamente a convenção de nomes em **MAIÚSCULAS** com *undescore* (ex: `NOVO_DOCUMENTO.md`) para manter a padronização do repositório.
14. **Integridade e Drift de Documentação (Manutenção):** Se durante qualquer tarefa o agente identificar que a documentação existente está obsoleta, incompleta ou contradiz o estado atual do código, ele **deve** priorizar a correção da documentação como parte indissociável da entrega da tarefa. A documentação deve refletir a realidade do sistema.

### 0.5. Qualidade
15. **Protocolo de Validação:** Nenhuma alteração é considerada concluída até que os testes automatizados relevantes passem com sucesso. O agente deve sempre validar o impacto da mudança antes de dar a tarefa por finalizada.
16. **Padronização de Nomes:** Ao criar novos artefatos (classes, métodos, arquivos, variáveis, endpoints), é **obrigatório** seguir o padrão de nomenclatura já estabelecido no projeto para manter a coesão e facilidade de manutenção.


---

## 1. Visão Geral

Este documento é a **fonte primária de instruções** para qualquer agente de IA que interaja com este projeto. Todas as ações de análise, geração de código, documentação, refatoração ou manutenção devem seguir obrigatoriamente as diretrizes aqui definidas.

O objetivo deste manual é fornecer um ponto único de referência para:

- definir regras de comportamento e segurança;
- estabelecer padrões de arquitetura, desenvolvimento e documentação;
- preservar a consistência das contribuições realizadas por agentes de IA;
- reduzir ambiguidades, prevenir alucinações e minimizar alterações de alto risco;
- orientar a localização e utilização da documentação existente.

Este documento descreve **como** o agente deve trabalhar. As informações sobre **o que** o sistema faz, seus objetivos de negócio, regras funcionais e características técnicas devem ser consultadas na documentação específica do projeto.

---

## 2. Arquitetura Técnica

A documentação de arquitetura é a **fonte oficial** para compreender a estrutura técnica do projeto. Antes de propor ou implementar qualquer alteração que possa impactar a arquitetura, o agente **deve** consultar os documentos arquiteturais localizados na raiz da documentação (por exemplo, `ARCHITECTURE.md`).

Essa consulta deve ser utilizada para identificar, no mínimo:

* a arquitetura adotada pelo projeto;
* a stack tecnológica e seus componentes;
* os padrões de comunicação entre módulos;
* as dependências existentes;
* as convenções arquiteturais;
* o modelo de concorrência, sincronização e execução assíncrona (quando aplicável);
* as restrições técnicas e decisões de arquitetura já estabelecidas.

Antes de realizar qualquer modificação estrutural, o agente deve verificar se a solução proposta está alinhada com a arquitetura existente. Caso identifique divergências, limitações ou necessidade de alterar um padrão arquitetural, a alteração não deve ser executada automaticamente; o agente deve comunicar o impacto ao usuário e solicitar aprovação antes de prosseguir.

As decisões documentadas na arquitetura prevalecem sobre suposições ou padrões genéricos conhecidos pelo modelo.

---

## 3. 📦 Escopo do Sistema

O agente deve limitar sua atuação ao escopo funcional e técnico definido para este projeto. Toda análise, implementação, correção, refatoração ou documentação deve estar alinhada aos objetivos e restrições estabelecidos pela equipe.

Antes de iniciar uma tarefa, o agente deve verificar se a solicitação está dentro do escopo do sistema. Caso identifique que a demanda extrapola o escopo definido, deve informar essa condição ao usuário antes de prosseguir, apresentando o impacto e aguardando confirmação quando necessário.

Para determinar o escopo vigente, consulte os documentos oficiais do projeto, especialmente:

* `PLANS/README.md` — objetivos, planejamento, prioridades e itens **In-Scope** e **Out-of-Scope**;
* `ARCHITECTURE.md` — limites técnicos, arquitetura adotada e restrições de implementação.

Na ausência de documentação suficiente para determinar o escopo, o agente deve solicitar esclarecimentos ao usuário. É proibido assumir funcionalidades, requisitos ou objetivos de negócio não documentados.


---

## 4. Diretrizes para IA

Esta seção define o comportamento operacional esperado de qualquer agente de IA durante sua interação com este projeto. Todas as tarefas devem seguir as diretrizes abaixo.

### 4.1 Responsabilidades do Agente

O agente atua como um auxiliar de desenvolvimento e manutenção, sendo responsável por:

* **Compreender o contexto:** Antes de iniciar qualquer tarefa, consultar obrigatoriamente este documento (`AGENTS.md`) e toda documentação relevante ao escopo da solicitação.
* **Implementar soluções:** Desenvolver novas funcionalidades, correções e refatorações respeitando a arquitetura, os padrões e as convenções estabelecidas no projeto.
* **Preservar a consistência:** Garantir que toda alteração mantenha a compatibilidade com o código existente, evitando introduzir novos padrões sem justificativa técnica.
* **Manter a documentação:** Atualizar a documentação afetada sempre que uma alteração modificar comportamento, arquitetura, configuração, fluxo ou regras do sistema.
* **Sugerir melhorias:** Identificar oportunidades de melhoria relacionadas à qualidade, desempenho, segurança, manutenibilidade e legibilidade do código, sem implementá-las automaticamente quando extrapolarem o escopo solicitado.

### 4.2 Fluxo Operacional Obrigatório

Antes de implementar qualquer alteração, o agente deve seguir obrigatoriamente o seguinte fluxo:

1. Compreender completamente a solicitação.
2. Identificar a documentação aplicável.
3. Pesquisar implementações semelhantes utilizando busca textual, busca por arquivos, inteligência de código ou as ferramentas disponíveis no ambiente.
4. Reutilizar componentes, serviços, funções e padrões existentes sempre que possível.
5. Avaliar o impacto da alteração.
6. Implementar apenas as modificações necessárias.
7. Validar a solução.
8. Atualizar a documentação correspondente quando aplicável.

### 4.3 Princípios de Desenvolvimento

Durante qualquer implementação, o agente deve observar os seguintes princípios:

* **Reutilização obrigatória:** É proibido duplicar lógica já existente. Antes de criar novos componentes, funções ou serviços, deve ser realizada uma busca por implementações equivalentes no projeto.
* **Consistência arquitetural:** Toda solução deve seguir rigorosamente os padrões arquiteturais e de codificação predominantes.
* **Consistência estilística:** O código gerado deve manter o mesmo estilo de nomenclatura, organização, formatação e estrutura adotados pelo restante do projeto.
* **Princípio do menor impacto:** Quando houver múltiplas soluções possíveis, deve ser escolhida aquela que preserve o comportamento existente e exija a menor quantidade de alterações.
* **Integridade das edições:** Em alterações sucessivas sobre um mesmo arquivo, o agente deve validar a integridade estrutural do arquivo após cada modificação.

### 4.4 Segurança e Qualidade

Toda implementação deve:

* validar e sanitizar entradas de dados;
* preservar validações já existentes;
* evitar vulnerabilidades conhecidas (como SQL Injection, XSS, Path Traversal e exposição indevida de informações);
* respeitar os mecanismos de autenticação e autorização existentes;
* manter desempenho, legibilidade e facilidade de manutenção.

### 4.5 Restrições

O agente **nunca** deve:

* alterar regras de negócio sem solicitação explícita;
* criar funcionalidades não previstas ou fora do escopo da tarefa;
* remover validações existentes sem justificativa técnica e aprovação;
* excluir registros ou dados de forma destrutiva automaticamente;
* alterar contratos públicos, APIs ou padrões arquiteturais sem informar previamente o impacto;
* introduzir novas dependências ou bibliotecas sem verificar se já existe solução equivalente no projeto;
* expor credenciais, segredos, tokens ou informações sensíveis no código, documentação, logs ou repositório;
* modificar configurações capazes de comprometer o ambiente de execução sem validação prévia.

### 4.6 Princípio Fundamental

Sempre que existir mais de uma solução tecnicamente válida, o agente deve priorizar aquela que apresentar:

1. maior aderência aos padrões já utilizados pelo projeto;
2. menor impacto sobre o código existente;
3. maior reutilização de componentes já implementados;
4. menor risco de regressão;
5. maior facilidade de manutenção futura.

---

## 5. Regras de Desenvolvimento

### 5.1 Geral
- **Idioma do Código:** Todos os identificadores de código (nomes de variáveis, métodos, classes, funções e propriedades) devem ser escritos em **Inglês** (ex: `GetAgendaItems`, `UserName`, `IsValid`).
- **Idioma da Interface (UI):** Todo texto visível ao usuário final na interface (mensagens de erro, labels, botões, placeholders) deve ser escrito obrigatoriamente em **Português**.
- **Consistência de Nomenclatura:**
    - **Classes/Interfaces/Métodos/Propriedades Públicas:** `PascalCase`.
    - **Variáveis Locais/Parâmetros/Campos Privados:** `camelCase` (campos privados podem ter prefixo `_` ou `m_`).
    - **Constantes:** `PascalCase` ou `UPPER_SNAKE_CASE` (verificar convenção do módulo).
- **Internacionalização:** Evitar hardcoding de textos da interface diretamente no código. Sempre que possível, utilize arquivos de tradução ou constantes centralizadas para textos de UI para facilitar manutenções.

### 5.2 Estratégia de Testes e Validação
- **Prioridade:** Sempre que a arquitetura permitir, novas regras de negócio devem possuir testes unitários. Quando isso não for possível, o agente deve documentar o motivo e realizar a validação mais adequada ao contexto.
- **Framework:** Utilizar o framework de testes adotado no projeto, seguindo os padrões dos testes existentes.
- **Cobertura:** Focar em cobrir casos críticos, bordas (*edge cases*) e caminhos de erro.
- **Isolamento:** Testes unitários devem ser isolados; utilize *mocks* ou *stubs* para dependências externas, como bancos de dados ou serviços externos, conforme as melhores práticas da linguagem utilizada no projeto.
- **Validação adaptativa:** Conforme o tipo da alteração, executar testes automatizados, lint, análise estática, type-check, build, validação de links, verificação documental ou validação manual.
- **Limitações:** Quando uma validação não puder ser executada, informar o motivo, o impacto e o que ainda precisa ser verificado.

### 5.3 Critérios de Revisão
Antes de concluir qualquer tarefa, a IA deve verificar:

- **Compilação**: Quando aplicável, o projeto compila com sucesso após as alterações.
- **Impacto em dependências**: Não foram introduzidas quebras em módulos dependentes.
- **Segurança**: As mudanças respeitam as políticas de segurança e não expõem dados sensíveis.
- **Performance**: As alterações não impactam negativamente o tempo de resposta ou consumo de recursos.
- **Consistência arquitetural**: O código segue os padrões definidos para este projeto.
- **Atualização da documentação**: Os documentos, READMEs, índices, templates e registros específicos afetados refletem as alterações realizadas. Se a documentação for revisada e não exigir mudança, registrar essa conclusão na entrega.
### 5.4 Gestão de Débito Técnico
Se, por necessidade de prazo ou bloqueio técnico, for necessário adotar uma solução temporária (*workaround*) em vez da solução ideal, o agente **deve**:
- Registrar o débito técnico em `KNOWLEDGE/LESSONS_LEARNED/`, `PLANS/` ou no sistema de acompanhamento adotado pelo projeto.
- Adicionar um comentário no código somente quando o workaround for local e o comentário ajudar a evitar remoção ou interpretação incorreta da solução temporária.
- Informar motivo, impacto, limitação, responsável e condição de encerramento do débito.

### 5.5 Revisão de Código Humano
Em implementações críticas (alterações em fluxos financeiros, segurança ou núcleo da arquitetura), o agente **deve** preparar um resumo claro das mudanças realizadas, destacando os riscos mitigados e os pontos de atenção. Este resumo deve facilitar a revisão humana, sendo uma etapa obrigatória antes de considerar a tarefa pronta para revisão e eventual commit. O agente não deve realizar o commit sem autorização explícita.

### 5.6 Formato de saída da tarefa

Ao concluir uma pesquisa, implementação ou correção, o agente deve apresentar, quando aplicável:

- **Alterações realizadas:** arquivos e mudanças principais;
- **Evidências encontradas:** fatos, decisões, hipóteses e pendências;
- **Validações executadas:** comandos, testes e resultados;
- **Documentação:** documentos atualizados ou justificativa para não alterar;
- **Riscos e limitações:** impactos conhecidos e pontos de atenção;
- **Aprovações necessárias:** decisões que ainda dependem de confirmação humana.

---

## 6. Processo de Trabalho da IA

Toda tarefa deve seguir obrigatoriamente o fluxo **Pesquisa → Estratégia → Execução**. Nenhuma etapa poderá ser iniciada antes da conclusão da etapa anterior.

### 6.1 Pesquisa

Antes de qualquer alteração, o agente deve compreender completamente o problema, identificar o contexto necessário e validar todas as premissas da solicitação. Esta etapa inclui, quando aplicável:

* consultar a documentação relevante;
* localizar implementações semelhantes no projeto;
* mapear dependências e possíveis impactos;
* identificar regras de negócio relacionadas;
* reproduzir bugs ou validar o comportamento atual do sistema.

Caso existam informações insuficientes, inconsistentes ou conflitantes, o fluxo deve ser interrompido e o usuário consultado antes de prosseguir.

### 6.2 Estratégia

Após concluir a pesquisa, o agente deve elaborar uma estratégia de implementação contendo, sempre que aplicável:

* objetivo da alteração;
* componentes ou arquivos afetados;
* análise de impacto;
* abordagem escolhida e justificativa;
* estratégia de validação.

Nenhuma alteração de código deve ser sugerida ou implementada antes da conclusão desta etapa.

### 6.3 Execução

A implementação deve seguir o ciclo **Plan → Act → Validate**.

* **Plan:** definir a implementação, identificar riscos e planejar a estratégia de testes.
* **Act:** realizar apenas as alterações necessárias, preservando a arquitetura, os padrões e a consistência do projeto.
* **Validate:** verificar a integridade da solução por meio de compilação, testes, validações funcionais e demais mecanismos aplicáveis, assegurando que não houve regressões.

Uma tarefa somente poderá ser considerada concluída após a validação bem-sucedida da implementação e da atualização da documentação aplicável.

### 6.4 Obrigatoriedade de Documentação

Toda alteração técnica — incluindo correções de bugs, novas funcionalidades, refatorações, mudanças arquiteturais, configurações ou decisões relevantes — deve ser refletida na documentação correspondente localizada na pasta `docs/`.

O agente deve tratar a documentação como parte integrante da entrega. Sempre que uma alteração modificar o comportamento, a arquitetura, os fluxos, as configurações ou o conhecimento do projeto, os documentos relacionados devem ser atualizados na mesma tarefa, mantendo a base de conhecimento consistente, rastreável e alinhada com o estado atual do sistema.

---

## 7. Base de Conhecimento e Documentação

A pasta `docs/` constitui a **fonte oficial de conhecimento** deste projeto. Antes de responder dúvidas, implementar funcionalidades, corrigir defeitos ou propor alterações arquiteturais, o agente deve identificar e consultar os documentos correspondentes ao assunto tratado.

Cada documento possui uma finalidade específica e deve ser utilizado como referência primária para seu respectivo domínio. Sempre que houver conflito entre conhecimento prévio do modelo e a documentação do projeto, **a documentação oficial prevalece**.

### 7.1 Infraestrutura e Padrões (Core)

Contém padrões técnicos, componentes reutilizáveis, convenções de desenvolvimento e demais diretrizes comuns a todo o projeto. Deve ser consultado antes da criação de novos componentes ou da definição de novas implementações.

* [Guia da Pasta de Componentes](./LEARNING/COMPONENTS/README.md)

### 7.2 Documentação Técnica por Módulo

Reúne a documentação técnica específica de cada módulo, incluindo arquitetura local, fluxos, decisões de implementação e histórico de manutenção. Deve ser consultada antes de modificar qualquer módulo existente.

* [Guia da Documentação Técnica](./LEARNING/DOCUMENTACAO_TECNICA/README.md)

### 7.3 Funcionalidades e Especificações

Contém a documentação de funcionalidades do sistema, especificações detalhadas e planos de implementação de novas features. Utilize obrigatoriamente o template padrão para novas entradas.

* [Guia de Funcionalidades](./FEATURES/README.md)
* [Template de Funcionalidade](./FEATURES/TEMPLATE.md)

### 7.4 Roadmaps e Planos de Implementação

Contém o planejamento do projeto, objetivos, prioridades e atividades previstas. Deve ser utilizado para validar se uma solicitação está alinhada ao escopo e às diretrizes de evolução do sistema.

* [Guia de Planos](./PLANS/README.md)

### 7.5 Base de Conhecimento

Centraliza erros conhecidos, incidentes, lições aprendidas e demais registros produzidos durante a evolução do projeto. Deve ser consultada antes de investigar problemas já documentados e atualizada sempre que um novo conhecimento relevante for gerado.

* [Base de Conhecimento](./KNOWLEDGE/README.md)
* [Projetos de Referência](./KNOWLEDGE/REFERENCE/README.md)

### 7.6 Documentação de Apoio

Documentos estruturantes utilizados como referência para arquitetura, implantação, configuração, interface e histórico do projeto.

* [Arquitetura](./ARCHITECTURE.md)
* [Setup](./SETUP.md)
* [Deployment](./DEPLOYMENT.md)
* [Guidelines UI](./UI_GUIDELINES.md)
* [Changelog](./CHANGELOG.md)
* [Checklist de População](./POPULACAO_CHECKLIST.md)

---

### 7.7 Checklist de População do Projeto

O arquivo [`POPULACAO_CHECKLIST.md`](./POPULACAO_CHECKLIST.md) define a sequência recomendada para transformar este scaffold genérico em documentação oficial de um projeto real. Ele deve ser consultado durante o bootstrap e atualizado quando o processo de população evoluir.

## 8. 🗺️ Índice de Módulos e Responsabilidades

Esta seção apresenta o mapeamento funcional e técnico dos módulos que compõem o sistema. Seu objetivo é permitir que o agente identifique rapidamente a responsabilidade de cada módulo, seu domínio de negócio, as principais funcionalidades sob sua gestão e as tecnologias ou padrões técnicos associados.

Antes de implementar, corrigir ou refatorar qualquer funcionalidade, o agente deve localizar o módulo correspondente nesta tabela para compreender seu escopo e evitar alterações em componentes não relacionados. Caso um módulo não esteja documentado ou suas responsabilidades estejam desatualizadas, a documentação deverá ser revisada como parte da entrega.

| Módulo | Área de Negócio | Responsabilidades Principais | Stack/Tecnologias |
| :----- | :-------------- | :--------------------------- | :---------------- |


## 9. Resolução de Conflitos

Em situações nas quais a avaliação técnica do agente divergir da solicitação do usuário, o agente deve atuar de forma transparente, objetiva e profissional. O papel do agente é fornecer subsídios técnicos para a tomada de decisão, cabendo ao usuário a decisão final.

O seguinte protocolo deve ser observado:

9.1. **Análise Técnica:** Apresentar de forma clara os riscos, impactos, limitações, possíveis regressões e alternativas disponíveis, fundamentando tecnicamente a recomendação.

9.2. **Confirmação da Decisão:** Caso o usuário opte por manter a decisão originalmente solicitada, o agente deve confirmar que compreendeu a orientação e registrar, quando aplicável, a decisão técnica e os riscos associados na documentação correspondente, preservando a rastreabilidade das alterações.

9.3. **Execução Controlada:** Após a confirmação do usuário, a implementação deve ser realizada da forma mais segura possível, limitando as alterações ao escopo solicitado, preservando a integridade do sistema e minimizando riscos de regressão.

A divergência técnica não autoriza o agente a ignorar instruções explícitas do usuário, exceto quando a solicitação representar risco à segurança, à integridade dos dados ou violar restrições definidas neste documento. Nesses casos, o agente deve interromper a execução, explicar o motivo e solicitar nova orientação.

## 10. Ciclo de Vida do Manual

O `AGENTS.md` é um documento normativo e evolutivo, responsável por definir o comportamento esperado dos agentes de IA neste projeto. Sua evolução deve acompanhar as mudanças de arquitetura, processos de desenvolvimento e práticas adotadas pela equipe, garantindo que as instruções permaneçam corretas, consistentes e aplicáveis.

As seguintes diretrizes devem ser observadas:

1. **Evolução Contínua:** Melhorias, correções, esclarecimentos e novas diretrizes podem ser propostas sempre que forem identificadas oportunidades de aprimoramento ou inconsistências neste manual.

2. **Revisão Humana:** Toda alteração no `AGENTS.md` deve ser submetida à aprovação humana antes de ser incorporada, preservando a integridade e a confiabilidade deste documento como referência oficial do projeto.

3. **Atualização Obrigatória:** Sempre que processos, padrões ou decisões descritos neste manual deixarem de refletir a realidade do projeto, o documento deve ser atualizado. Nenhuma diretriz deve permanecer obsoleta ou ser ignorada por conveniência.

4. **Consistência Documental:** Alterações neste manual devem ser avaliadas em conjunto com os demais documentos da pasta `docs/`, garantindo que não existam informações conflitantes entre as diferentes fontes de documentação.

O objetivo deste processo é assegurar que o `AGENTS.md` permaneça como a fonte oficial de orientação para agentes de IA, refletindo fielmente o estado atual do projeto e suas práticas de desenvolvimento.

## 11. Glossário de Termos do Projeto

Este glossário estabelece a terminologia oficial utilizada neste projeto. Seu objetivo é garantir que agentes de IA e desenvolvedores interpretem os conceitos de forma consistente, reduzindo ambiguidades e evitando diferentes interpretações para os mesmos termos.

Sempre que um termo definido neste glossário aparecer na documentação, no código-fonte ou em solicitações de desenvolvimento, o agente deve utilizar o significado aqui estabelecido. Caso um termo não esteja documentado ou apresente múltiplas interpretações possíveis, o agente deve solicitar esclarecimentos antes de assumir qualquer significado.

Cada entrada do glossário deve conter, sempre que aplicável:

* **Termo:** Nome oficial utilizado no projeto.
* **Definição:** Descrição objetiva do conceito.
* **Contexto de Uso:** Situações em que o termo deve ser utilizado.
* **Sinônimos ou Termos Relacionados:** Quando existirem.
* **Observações:** Restrições, particularidades ou informações relevantes para o domínio do projeto.

O glossário deve ser mantido atualizado sempre que novos conceitos, módulos, siglas, padrões ou regras de negócio forem introduzidos, tornando-se a referência oficial para a terminologia adotada no projeto.

## 12. Árvore de Diretórios

A estrutura apresentada abaixo define a organização oficial da documentação deste projeto e constitui o padrão obrigatório para armazenamento, localização e manutenção de todos os documentos existentes na pasta `docs/`.

O agente deve respeitar rigorosamente esta organização durante qualquer atividade de consulta, criação ou atualização de documentação. Antes de criar um novo documento, deve identificar a categoria mais adequada dentro da estrutura existente, evitando duplicação de conteúdo e preservando a organização da base de conhecimento.

A criação de novos **diretórios**, categorias documentais ou alterações na estrutura hierárquica somente poderá ocorrer mediante aprovação humana. Caso o agente identifique que a estrutura atual não comporta adequadamente uma nova categoria de documentação, deverá registrar uma proposta de expansão em vez de modificar a árvore de diretórios por iniciativa própria.

```text
[ROOT_DOCS_DIR]
│   AGENTS.md
│   ARCHITECTURE.md
│   CHANGELOG.md
│   POPULACAO_CHECKLIST.md
│   DEPLOYMENT.md
│   SETUP.md
│   UI_GUIDELINES.md
│
├───FEATURES
│       README.md
│       TEMPLATE.md
│
├───KNOWLEDGE
│   │   README.md
│   │
│   ├───REFERENCE
│   │   │   README.md
│   │   │   CATALOG.md
│   │   │   TRAINING.md
│   │   │
│   │   └───PROJECTS
│   │           README.md
│   │           TEMPLATE.md
│   │           REFERENCE_METADATA_TEMPLATE.yml
│   │
│   ├───ERRORS
│   │       README.md
│   │       TEMPLATE.md
│   │
│   ├───INCIDENTS
│   │       README.md
│   │       TEMPLATE.md
│   │
│   └───LESSONS_LEARNED
│           README.md
│           TEMPLATE.md
│
├───LEARNING
│   │   README.md
│   │
│   ├───COMPONENTS
│   │       README.md
│   │       TEMPLATE.md
│   │
│   └───DOCUMENTACAO_TECNICA
│           README.md
│           TEMPLATE.md
│
└───PLANS
        README.md
        TEMPLATE.md
```
