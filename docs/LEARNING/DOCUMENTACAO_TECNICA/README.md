# Documentação Técnica dos Módulos

A pasta `docs/LEARNING/DOCUMENTACAO_TECNICA/` contém a documentação técnica detalhada dos módulos, funcionalidades e componentes internos do sistema.

## Catálogo dos módulos atuais

- [`MODULOS.md`](./MODULOS.md) — responsabilidades, dependências, estrutura, configurações e limitações dos módulos Android `:componentes` e `:app`.
- [`CATALOGO_COMPONENTES.md`](../COMPONENTS/CATALOGO_COMPONENTES.md) — inventário das views, helpers e atributos XML públicos da biblioteca.

Seu objetivo é centralizar o conhecimento necessário para que desenvolvedores e agentes de IA consigam compreender o funcionamento de cada parte da aplicação antes de realizar alterações, correções ou novas implementações.

Esta documentação deve representar o **estado técnico atual do módulo**, incluindo arquitetura, responsabilidades, regras de negócio, dependências e histórico relevante de decisões.

---

# 🤖 Diretrizes para Agentes de IA

Antes de modificar qualquer módulo existente, a IA deve consultar a documentação técnica correspondente.

A análise deve considerar:

- Responsabilidade do módulo.
- Fluxo de execução.
- Regras de negócio existentes.
- Dependências internas e externas.
- Impactos em outros módulos.
- Restrições técnicas conhecidas.

Caso uma alteração modifique o comportamento do módulo, a IA deve atualizar a documentação correspondente após a implementação.

---

# Objetivos

Esta documentação tem como objetivos:

## Agilidade na Manutenção

Permitir que desenvolvedores e agentes de IA compreendam rapidamente:

- O propósito do módulo.
- Onde estão localizadas suas principais responsabilidades.
- Como ocorre o fluxo de dados.
- Quais pontos devem receber atenção durante alterações.


## Redução de Erros

Registrar informações importantes para evitar alterações incorretas, incluindo:

- Regras de negócio específicas.
- Validações obrigatórias.
- Dependências críticas.
- Comportamentos esperados.


## Preservação de Conhecimento

Manter o conhecimento técnico acumulado durante a evolução do sistema:

- Decisões tomadas anteriormente.
- Motivos de determinadas implementações.
- Limitações conhecidas.
- Pontos que exigem cuidado.


---

# Quando Criar ou Atualizar uma Documentação

Um documento técnico de módulo deve ser criado ou atualizado quando ocorrer:

- Criação de um novo módulo.
- Alteração significativa de uma funcionalidade.
- Mudança de regra de negócio.
- Alteração arquitetural.
- Inclusão de uma integração externa.
- Correção que altere comportamento esperado.
- Descoberta de uma regra implícita existente.


---

# Estrutura dos Documentos

Utilize [`TEMPLATE.md`](./TEMPLATE.md) para iniciar a documentação de um módulo. O documento deve ser atualizado quando o comportamento técnico, as dependências ou as responsabilidades do módulo mudarem.

Cada documento técnico deve seguir preferencialmente a estrutura abaixo:

```markdown
# Nome do Módulo

## 1. Objetivo

Descrever a finalidade principal do módulo.


## 2. Responsabilidade

Definir claramente quais responsabilidades pertencem ao módulo.

Informar também o que **não deve ser responsabilidade dele**.


## 3. Localização no Projeto

Informar os principais caminhos:

Exemplo:
