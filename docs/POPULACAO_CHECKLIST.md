# Checklist de População do Projeto

Este checklist orienta o agente durante a transformação do scaffold documental em documentação oficial de um projeto real.

O objetivo não é preencher campos por inferência, mas registrar informações sustentadas pelo código, pela infraestrutura, pelos requisitos e pelas decisões humanas.

## 1. Regras de uso

- [ ] Ler `AGENTS.md` antes de iniciar.
- [ ] Identificar o tipo da tarefa e consultar a documentação específica.
- [ ] Distinguir placeholders, exemplos, hipóteses e decisões oficiais.
- [ ] Não transformar uma suposição em decisão oficial.
- [ ] Pesquisar o repositório antes de preencher informações técnicas.
- [ ] Solicitar esclarecimentos quando houver ambiguidade relevante.
- [ ] Preservar a estrutura genérica quando não houver informação real.
- [ ] Atualizar a documentação somente após confirmar a evidência.
- [ ] Validar links, nomes, comandos e referências após as alterações.

## 2. Ordem recomendada de população

### 2.1 Identidade e escopo

Documentos: `AGENTS.md`, `PLANS/README.md`

- [ ] Identificar o objetivo do projeto.
- [ ] Registrar o escopo funcional conhecido.
- [ ] Registrar explicitamente o que está fora do escopo, quando aplicável.
- [ ] Identificar usuários, consumidores ou sistemas integrados.
- [ ] Registrar requisitos já confirmados.
- [ ] Separar requisitos confirmados de hipóteses e itens pendentes.

### 2.2 Arquitetura

Documento: `ARCHITECTURE.md`

- [ ] Identificar o tipo de aplicação.
- [ ] Registrar a plataforma e o modelo de execução.
- [ ] Preencher somente tecnologias realmente adotadas.
- [ ] Mapear módulos, camadas e responsabilidades.
- [ ] Registrar dependências permitidas entre camadas.
- [ ] Identificar contratos públicos, APIs e integrações.
- [ ] Registrar decisões arquiteturais adotadas.
- [ ] Registrar alternativas rejeitadas quando a decisão for relevante.
- [ ] Documentar restrições, riscos e pontos ainda pendentes.
- [ ] Confirmar que a arquitetura documentada corresponde ao código atual.

### 2.3 Ambiente de desenvolvimento

Documento: `SETUP.md`

- [ ] Listar sistemas operacionais suportados.
- [ ] Registrar versões mínimas e recomendadas das ferramentas.
- [ ] Documentar pré-requisitos.
- [ ] Documentar instalação de dependências.
- [ ] Documentar configuração local necessária.
- [ ] Identificar variáveis de ambiente sem registrar segredos ou valores sensíveis.
- [ ] Documentar comandos para executar a aplicação.
- [ ] Documentar comandos para lint, testes, build e verificações.
- [ ] Documentar problemas conhecidos de configuração.
- [ ] Validar os comandos em um ambiente limpo quando possível.

### 2.4 Interface

Documento: `UI_GUIDELINES.md`

- [ ] Confirmar se o projeto possui interface de usuário.
- [ ] Registrar plataformas e tamanhos de tela suportados.
- [ ] Identificar biblioteca ou sistema de componentes adotado.
- [ ] Registrar padrões de layout, navegação e responsividade.
- [ ] Registrar estados de carregamento, vazio, erro e sucesso.
- [ ] Registrar regras de acessibilidade aplicáveis.
- [ ] Registrar idioma e regras de textos visíveis ao usuário.
- [ ] Documentar tokens, temas ou padrões visuais somente quando existirem.
- [ ] Evitar criar regras visuais sem evidência ou decisão do produto.

### 2.5 Funcionalidades

Documento: `FEATURES/README.md` e documentos específicos em `FEATURES/`

- [ ] Listar somente funcionalidades identificadas no produto.
- [ ] Registrar objetivo e contexto de cada funcionalidade.
- [ ] Registrar atores e pré-condições.
- [ ] Registrar fluxo principal.
- [ ] Registrar fluxos alternativos e casos de erro.
- [ ] Registrar regras de negócio confirmadas.
- [ ] Definir critérios de aceite verificáveis.
- [ ] Registrar dependências e impacto em outros módulos.
- [ ] Registrar status da funcionalidade.
- [ ] Evitar documentar funcionalidades apenas planejadas como se já existissem.

### 2.6 Conhecimento e aprendizado

Documentos: `KNOWLEDGE/` e `LEARNING/`

- [ ] Registrar erros conhecidos com causa, impacto e solução.
- [ ] Registrar incidentes com contexto, linha do tempo e prevenção.
- [ ] Registrar lições aprendidas após investigações relevantes.
- [ ] Registrar estudos técnicos, alternativas e resultados.
- [ ] Separar problemas resolvidos de pesquisas ainda inconclusivas.
- [ ] Vincular registros aos módulos, versões ou alterações relacionadas.
- [ ] Não apagar estudos descartados sem aprovação.

### 2.7 Projetos de referência

Documentos: `KNOWLEDGE/REFERENCE/` e `KNOWLEDGE/REFERENCE/PROJECTS/`

- [ ] Confirmar a finalidade da referência antes de adicioná-la.
- [ ] Confirmar origem, licença ou autorização de uso.
- [ ] Remover credenciais, dados pessoais e configurações sensíveis.
- [ ] Manter cada projeto isolado em sua própria pasta.
- [ ] Criar `README.md` a partir do template do projeto.
- [ ] Criar `.reference.yml` com metadados preenchidos.
- [ ] Definir status, tecnologias, versões, tags e compatibilidade.
- [ ] Registrar limitações, riscos e partes que não devem ser copiadas.
- [ ] Atualizar `CATALOG.md`.
- [ ] Validar que a referência não foi confundida com o código oficial.

### 2.8 Implantação

Documento: `DEPLOYMENT.md`

- [ ] Identificar ambientes reais.
- [ ] Registrar finalidade, branch e processo de cada ambiente.
- [ ] Documentar build e publicação.
- [ ] Documentar configurações necessárias sem expor segredos.
- [ ] Registrar migrações e pré-condições de deploy, quando aplicável.
- [ ] Definir verificações pós-publicação.
- [ ] Documentar rollback e recuperação.
- [ ] Registrar responsáveis e aprovações exigidas.
- [ ] Validar se o fluxo documentado corresponde à infraestrutura real.

### 2.9 Histórico

Documento: `CHANGELOG.md`

- [ ] Confirmar o padrão de versionamento adotado.
- [ ] Registrar alterações relevantes após validação.
- [ ] Separar alterações não publicadas de versões liberadas.
- [ ] Incluir contexto suficiente para agentes futuros.
- [ ] Não registrar credenciais, dados sensíveis ou detalhes operacionais indevidos.

## 3. Critérios de conclusão

A população inicial pode ser considerada concluída quando:

- [ ] Os placeholders ainda pendentes estão identificados claramente.
- [ ] As decisões oficiais estão separadas de exemplos e hipóteses.
- [ ] Os documentos principais apontam para referências existentes.
- [ ] A arquitetura corresponde ao estado real do projeto.
- [ ] O ambiente pode ser configurado seguindo `SETUP.md`.
- [ ] Os comandos documentados foram validados ou marcados como não validados.
- [ ] As funcionalidades documentadas possuem fonte ou critério de aceite.
- [ ] O processo de deploy está documentado ou explicitamente marcado como pendente.
- [ ] Não há segredos ou dados sensíveis na documentação.
- [ ] O `CHANGELOG.md` registra a população documental inicial, quando aplicável.

## 4. Saída esperada do agente

Ao finalizar uma rodada de população, o agente deve apresentar:

1. documentos atualizados;
2. decisões confirmadas;
3. placeholders que continuam pendentes;
4. hipóteses que exigem validação humana;
5. comandos e testes executados;
6. inconsistências encontradas entre código e documentação;
7. riscos ou próximos bloqueios relevantes.
