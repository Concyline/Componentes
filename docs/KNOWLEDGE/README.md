# Base de Conhecimento

Esta pasta centraliza registros de conhecimento compartilhado, erros conhecidos, incidentes técnicos e lições aprendidas durante o desenvolvimento.

# 🤖 Diretrizes para Agentes de IA

A pasta `docs/knowledge/` representa a **memória operacional do projeto** e deve ser considerada uma fonte de consulta obrigatória antes de realizar correções, alterações estruturais ou implementações relacionadas a problemas existentes.

Antes de iniciar qualquer alteração técnica, a IA deve verificar nesta pasta:

- Erros conhecidos relacionados ao problema atual.
- Incidentes anteriores envolvendo o mesmo componente ou módulo.
- Lições aprendidas que possam influenciar a implementação.
- Soluções já aplicadas anteriormente.

O objetivo é evitar a repetição de investigações, impedir a criação de correções conflitantes e preservar decisões técnicas já validadas.

## Propósito como scaffold genérico

Este diretório funciona como memória operacional reutilizável para projetos novos. Ele organiza a antecipação de problemas, erros recorrentes e aprendizados técnicos, mas precisa ser preenchido com registros reais do projeto quando o contexto existir.

A estrutura é a base para que o agente registre:

- falhas detectadas;
- causas e impactos;
- correções aplicadas;
- conclusões e prevenção futura.

## Projetos de referência

A pasta [`REFERENCE/`](./REFERENCE/README.md) contém outros projetos, recortes de código e artefatos técnicos autorizados para consulta e treinamento operacional dos agents. Esses materiais são auxiliares e não representam automaticamente a arquitetura, as regras ou o código oficial do projeto atual.

## Índice
- [Erros Conhecidos](./ERRORS/README.md)
- [Incidentes Técnicos](./INCIDENTS/README.md)
- [Lições Aprendidas](./LESSONS_LEARNED/README.md)
- [Projetos de Referência](./REFERENCE/README.md)
