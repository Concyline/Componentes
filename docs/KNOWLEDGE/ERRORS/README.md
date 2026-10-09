# Registro de Erros e Soluções

Este diretório contém o histórico de erros relevantes encontrados durante o desenvolvimento e manutenção do projeto. O objetivo é criar uma base de conhecimento para facilitar a resolução de problemas recorrentes e guiar futuros desenvolvedores (e IAs).

## 🤖 Diretrizes para IA
Antes de implementar qualquer correção, a IA **deve** pesquisar nesta pasta por erros similares. Após a validação da correção, é **obrigatório** registrar o erro aqui seguindo o padrão abaixo.

## Padrão de Registro
Cada erro deve ser registrado em um novo arquivo Markdown (`ERRO-XXX-descricao-curta.md`) seguindo o formato abaixo:

Utilize [`TEMPLATE.md`](./TEMPLATE.md) como ponto de partida. O template pode ser adaptado quando o erro exigir informações específicas, mas não deve transformar hipóteses em causas confirmadas.

```markdown
# [ERRO-XXX] [Título do Erro]

**Data:** [DD/MM/AAAA]
**Severidade:** [Baixa / Média / Alta / Crítica]

### 1. Contexto
[Onde e quando o erro ocorreu.]

### 2. Mensagem
[Mensagem de erro exata exibida no console ou log.]

### 3. Causa
[Análise técnica da raiz do problema.]

### 4. Solução
[Passos realizados para a correção.]

### 5. Como evitar
[Dica ou diretriz para evitar que este erro ocorra novamente.]
```

## Índice de Erros
