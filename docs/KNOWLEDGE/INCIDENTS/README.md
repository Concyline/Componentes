# Registro de Incidentes

Este diretório armazena o histórico de **incidentes críticos ou sistêmicos** (ex: queda de serviço, falha massiva de autenticação, corrupção de dados) que impactam a operação do projeto.

## 🤖 Diretrizes para IA
A documentação de incidentes é obrigatória após a contenção de qualquer falha crítica. A IA deve utilizar este registro como base para análise de riscos e para fortalecer a arquitetura do sistema.

## Padrão de Registro
Cada incidente deve ser registrado em um novo arquivo Markdown (`INC-XXX-descricao-curta.md`) seguindo o formato abaixo:

Utilize [`TEMPLATE.md`](./TEMPLATE.md) como ponto de partida e mantenha fatos, hipóteses e ações futuras claramente separados.

```markdown
# [INC-XXX] [Título do Incidente]

**Data:** [DD/MM/AAAA]
**Severidade:** [Crítica / Alta]

### 1. Descrição
[O que aconteceu, qual o impacto no usuário e quais serviços foram afetados.]

### 2. Ações Imediatas
[O que foi feito para conter o incidente e restaurar o serviço.]

### 3. Causa Raiz
[Análise técnica do motivo da falha (Root Cause Analysis).]

### 4. Resolução Definitiva
[Ações de longo prazo tomadas para corrigir a causa base.]

### 5. Plano de Prevenção
[O que será feito para evitar que este incidente ocorra novamente (ex: automação, novas validações, monitoramento).]
```

## Índice de Incidentes
*(Adicione novos incidentes aqui)*
