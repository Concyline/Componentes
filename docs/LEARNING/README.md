# Base de Conhecimento de Estudos e Aprendizado

A pasta `docs/learning/` representa a área de **aprendizado técnico contínuo do projeto**.

Seu objetivo é armazenar estudos, pesquisas, experimentos, provas de conceito (POCs), análises de tecnologias e descobertas realizadas durante a evolução do sistema.

Esta documentação deve registrar não apenas soluções adotadas, mas também alternativas avaliadas e descartadas, garantindo histórico técnico e evitando que agentes de IA ou desenvolvedores repitam investigações já realizadas.

Diferente da pasta `docs/knowledge/`, que registra **problemas conhecidos, erros encontrados e suas respectivas soluções**, a pasta `docs/learning/` representa a etapa de **exploração, aprendizado e tomada de decisão técnica**.

## Propósito como scaffold genérico

Este diretório é um template de memória de investigação para projetos novos. Ele permite que o agente registre rapidamente:

- tecnologias avaliadas;
- trade-offs técnicos;
- protótipos e testes de viabilidade;
- justificativas de decisões adotadas ou recusadas;
- referências para futuras implementações.

O scaffold busca preservar conhecimento sem bloquear o time em padrões fixos antes da maturidade do projeto.

---

# 🤖 Diretrizes para Agentes de IA

A IA deve utilizar esta pasta sempre que realizar uma investigação técnica relevante, incluindo:

- Avaliação de novas tecnologias.
- Comparação entre bibliotecas ou frameworks.
- Estudos de arquitetura.
- Testes de viabilidade.
- Análise de desempenho.
- Avaliação de padrões de desenvolvimento.
- Pesquisas para tomada de decisão futura.

A IA **não deve remover estudos antigos**, mesmo quando a tecnologia analisada não for utilizada.

Estudos descartados possuem valor histórico, pois:

- Evitam repetição de pesquisas.
- Explicam decisões arquiteturais tomadas.
- Permitem compreender alternativas avaliadas.
- Facilitam futuras mudanças tecnológicas.

---

# Relação com Outras Documentações

A IA deve manter a separação correta entre os documentos:

| Documento | Responsabilidade |
|-----------|------------------|
| `AGENTS.md` | Regras obrigatórias de atuação da IA no projeto. |
| `ARCHITECTURE.md` | Decisões arquiteturais oficiais e padrões adotados. |
| `docs/learning/` | Estudos, pesquisas e experimentações. |
| `docs/knowledge/` | Problemas encontrados e soluções aplicadas. |
| `CHANGELOG.md` | Histórico de alterações realizadas no projeto. |

---

# Processo de Evolução do Conhecimento

O fluxo esperado é:

```text
Necessidade Técnica

        ↓

Pesquisa / Investigação

        ↓

Registro em docs/learning/

        ↓

Teste ou Protótipo

        ↓

Avaliação dos Resultados

        ↓

Decisão

        ↓

Atualização da documentação oficial
```