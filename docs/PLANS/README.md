# Planos de Implementação

A pasta `docs/PLANS/` contém documentos de planejamento técnico utilizados antes da execução de alterações relevantes no sistema.

Seu objetivo é registrar a estratégia de implementação, escopo, decisões técnicas, riscos e etapas necessárias para realizar novas funcionalidades, correções complexas, migrações, refatorações ou mudanças arquiteturais.

Esta documentação representa a etapa de **planejamento e preparação**, servindo como guia para desenvolvedores e agentes de IA durante a execução das alterações.

## Propósito como scaffold genérico

Este diretório funciona como base de planejamento para projetos novos. Em vez de exigir uma solução definitiva antes do projeto existir, ele define um padrão para registrar:

- objetivos e escopo;
- impacto e riscos;
- sequência de execução;
- critérios de sucesso;
- decisão de aplicar ou não um plano formal.

Assim, o agente pode iniciar rapidamente o processo sem perder rigor, e depois popular a estrutura conforme a complexidade real da entrega.

---

# 🤖 Diretrizes para Agentes de IA

Antes de iniciar alterações significativas no código, a IA deve avaliar se é necessário criar ou consultar um plano de implementação existente.

Um plano deve ser criado quando a alteração envolver:

- Nova funcionalidade relevante.
- Alteração arquitetural.
- Migração de tecnologia.
- Refatoração de grande impacto.
- Alteração que afete múltiplos módulos.
- Mudanças com risco elevado.
- Alterações que necessitem de várias etapas.


Alterações pequenas e isoladas podem ser realizadas sem plano formal quando:

- Possuem baixo impacto.
- Não alteram arquitetura.
- Não afetam outros módulos.
- Possuem implementação simples e direta.


---

# Objetivos

## Alinhamento Técnico

Garantir que a solução proposta seja compreendida antes da implementação.

O plano deve definir:

- Qual problema será resolvido.
- Qual abordagem será utilizada.
- Quais componentes serão afetados.
- Quais decisões técnicas foram tomadas.


## Rastreabilidade

Manter histórico das decisões de implementação:

- Motivo da alteração.
- Estratégia escolhida.
- Alternativas consideradas.
- Responsáveis envolvidos.
- Resultado final.


## Redução de Riscos

Permitir identificar antecipadamente:

- Impactos inesperados.
- Dependências existentes.
- Pontos críticos.
- Necessidade de migração.
- Estratégias de rollback.


## Execução Controlada

Garantir que a implementação siga uma sequência definida:

- Preparação.
- Desenvolvimento.
- Validação.
- Publicação.
- Documentação.


---

# 🤖 Processo Obrigatório para IA

Utilize [`TEMPLATE.md`](./TEMPLATE.md) para criar um plano novo. O template é um ponto de partida e deve ser preenchido com evidências do projeto, sem inventar requisitos, riscos ou decisões.

Antes de executar um plano:

```text
Solicitação de alteração

        ↓

Avaliar complexidade e impacto

        ↓

Existe plano?

        ↓

Sim → Utilizar plano existente

Não → Criar novo plano

        ↓

Revisão / Aprovação

        ↓

Executar implementação

        ↓

Atualizar documentação relacionada
```