# Treinamento Operacional com Projetos de Referência

Este documento define como agents devem utilizar os projetos armazenados em `REFERENCE/PROJECTS/` para ampliar o contexto técnico durante uma tarefa.

Este processo é uma forma de **treinamento operacional por consulta**. Ele não altera permanentemente o modelo de IA e não transforma automaticamente os projetos de referência em padrões oficiais do projeto atual.

## Objetivo

O treinamento com referências deve ajudar o agent a:

- localizar soluções semelhantes;
- reconhecer padrões de código e organização;
- comparar abordagens técnicas;
- identificar riscos e limitações;
- propor adaptações compatíveis com o projeto atual;
- justificar decisões com base em exemplos reais;
- evitar repetir investigações já realizadas.

## Pré-condições

Antes de iniciar, o agent deve:

- [ ] Ler `AGENTS.md`.
- [ ] Consultar a documentação relevante da tarefa.
- [ ] Identificar o problema ou objetivo atual.
- [ ] Verificar se existe projeto de referência relacionado.
- [ ] Confirmar que a referência possui `README.md` e `.reference.yml`.
- [ ] Verificar status, autorização, licença e sensibilidade do material.
- [ ] Confirmar que nenhum segredo ou dado sensível será exposto.

Se não houver projeto cadastrado ou se a referência estiver incompleta, o agent deve continuar sem inventar conteúdo e registrar a limitação.

## Ciclo de treinamento

### 1. Definir o objetivo

Descreva o que precisa ser aprendido ou comparado.

Exemplos:

- entender uma estrutura de serviço em C#;
- comparar validações de XML;
- identificar um padrão de tratamento de erros;
- encontrar uma estratégia de integração externa;
- avaliar organização de módulos.

### 2. Selecionar a referência

Consulte `CATALOG.md` e selecione a referência mais relevante por:

- tecnologia;
- versão;
- finalidade;
- tags;
- compatibilidade;
- status;
- autorização de uso.

Não selecione uma referência apenas por possuir arquivos com nomes parecidos.

### 3. Estudar o contexto

Leia o `README.md` do projeto de referência e registre:

- qual problema o projeto resolve;
- quais partes são relevantes;
- quais decisões dependem do contexto original;
- quais limitações foram documentadas;
- quais conteúdos não podem ser copiados ou reutilizados.

### 4. Comparar com o projeto atual

Faça a comparação antes de sugerir qualquer adaptação:

| Aspecto | Projeto atual | Referência | Compatibilidade |
|---|---|---|---|
| Linguagem | [PENDENTE] | [PENDENTE] | [PENDENTE] |
| Framework | [PENDENTE] | [PENDENTE] | [PENDENTE] |
| Arquitetura | [PENDENTE] | [PENDENTE] | [PENDENTE] |
| Contratos | [PENDENTE] | [PENDENTE] | [PENDENTE] |
| Testes | [PENDENTE] | [PENDENTE] | [PENDENTE] |

Classifique cada conclusão como `[FATO]`, `[HIPÓTESE]`, `[DECISÃO]` ou `[PENDENTE]`.

### 5. Extrair o aprendizado

O agent deve separar:

- **Padrão reutilizável:** ideia geral que pode ser adaptada;
- **Detalhe específico:** implementação ligada ao projeto de origem;
- **Risco:** comportamento que pode causar regressão;
- **Dependência:** requisito técnico necessário;
- **Decisão necessária:** escolha que depende do projeto atual;
- **Conteúdo proibido:** segredo, dado sensível ou material sem autorização.

### 6. Propor a adaptação

Antes de implementar, descreva:

- o que será aproveitado;
- o que será descartado;
- o que será adaptado;
- quais arquivos serão afetados;
- quais riscos existem;
- como a solução será validada.

O código da referência não deve ser copiado automaticamente. A solução deve seguir a arquitetura e as convenções do projeto atual.

### 7. Validar

Após a adaptação, execute as validações aplicáveis:

- testes automatizados;
- lint, análise estática ou type-check;
- build;
- validação de XML ou contratos;
- testes de integração;
- revisão de segurança;
- validação manual documentada.

Se a referência não puder ser executada, use-a apenas como material de comparação e registre essa limitação.

### 8. Registrar o resultado

Ao finalizar, registre:

- referência utilizada;
- objetivo do treinamento;
- aprendizados extraídos;
- diferenças encontradas;
- adaptação realizada;
- validações executadas;
- riscos e limitações;
- documentação oficial atualizada;
- decisões que ainda dependem de aprovação.

## Modelo de relatório

```markdown
# Treinamento com Referência

**Referência:** `PROJECT_XXX`
**Objetivo:** Descrever o que foi investigado
**Status:** `DRAFT | CONCLUÍDO | PENDENTE`

## Evidências

- [FATO] Evidência encontrada na referência.
- [FATO] Evidência encontrada no projeto atual.
- [HIPÓTESE] Interpretação ainda não confirmada.

## Aprendizados

- Padrão:
- Risco:
- Dependência:

## Comparação

| Aspecto | Projeto atual | Referência | Resultado |
|---|---|---|---|
| Arquitetura | Descrição | Descrição | Compatível ou não |

## Adaptação proposta ou realizada

Descreva a solução sem assumir que a referência é normativa.

## Validação

- Comando ou teste:
- Resultado:

## Pendências e aprovações

- Decisão pendente:
```

## Critérios de qualidade

O treinamento foi realizado corretamente quando:

- a referência foi selecionada por contexto;
- sua origem e autorização foram verificadas;
- o projeto atual foi analisado antes da adaptação;
- fatos foram separados de hipóteses;
- nenhum segredo ou dado sensível foi reutilizado;
- a referência não foi tratada como arquitetura oficial;
- a solução adaptada foi validada;
- o resultado foi documentado.

## Regra final

> Projetos de referência ensinam por comparação. Eles não substituem a análise do projeto atual, a documentação oficial, os requisitos do usuário ou a validação humana de decisões relevantes.
