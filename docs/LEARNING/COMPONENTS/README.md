# Componentes e Infraestrutura

A pasta `docs/LEARNING/COMPONENTS/` contém a documentação técnica dos componentes reutilizáveis, padrões de implementação, contratos compartilhados e recursos de infraestrutura que servem como base para evolução do projeto.

## Catálogo do projeto

- [`CATALOGO_COMPONENTES.md`](./CATALOGO_COMPONENTES.md) — inventário dos componentes, APIs públicas observadas, atributos XML, dependências e limitações da biblioteca Android `:componentes`.
- [`MODULOS.md`](../DOCUMENTACAO_TECNICA/MODULOS.md) — responsabilidades, dependências e configurações dos módulos Gradle `:componentes` e `:app`.

Esta documentação representa o conhecimento técnico relacionado a elementos que podem ser utilizados por múltiplos módulos da aplicação, evitando duplicação de soluções e garantindo uniformidade entre diferentes partes do sistema.

---

# 🤖 Diretrizes para Agentes de IA

Antes de criar um novo componente, serviço compartilhado ou infraestrutura técnica, a IA deve consultar esta pasta para verificar se já existe uma solução padronizada.

A IA deve priorizar:

- Reutilização de componentes existentes.
- Evolução de soluções já implementadas.
- Manutenção dos padrões definidos.
- Evitar criação de implementações paralelas para o mesmo objetivo.

Antes de criar um novo componente, verificar:

- Já existe uma implementação equivalente?
- O componente deve realmente ser compartilhado?
- A responsabilidade pertence a um componente comum ou a um módulo específico?
- A nova solução segue os padrões arquiteturais definidos?


---

# Objetivos

## Reuso de Código

Centralizar soluções comuns para evitar:

- Código duplicado.
- Implementações inconsistentes.
- Diferentes abordagens para o mesmo problema.

Exemplos:

- Componentes de interface.
- Serviços compartilhados.
- Clientes HTTP.
- Validadores.
- Helpers.
- Extensões.


---

## Consistência Técnica

Garantir que novos componentes sigam os mesmos padrões relacionados a:

- Organização de código.
- Nomenclatura.
- Responsabilidades.
- Tratamento de erros.
- Segurança.
- Performance.


---

## Manutenibilidade

Facilitar a evolução do sistema através de:

- Documentação clara.
- Exemplos de utilização.
- Definição de responsabilidades.
- Registro de decisões técnicas.


---

# Tipos de Componentes Documentados

Esta pasta pode conter documentações relacionadas a:

## Componentes de Frontend

Exemplos:

- Componentes visuais reutilizáveis.
- Layouts.
- Modais.
- Tabelas.
- Formulários.
- Padrões CSS.
- Bibliotecas internas.


## Serviços Backend

Exemplos:

- Serviços compartilhados.
- Middlewares.
- Providers.
- Clientes externos.
- Serviços de autenticação.
- Serviços de notificação.


## Contratos e Integrações

Exemplos:

- Contratos de API.
- DTOs compartilhados.
- Modelos de comunicação.
- Integrações externas.


## Infraestrutura

Exemplos:

- Banco de dados.
- Cache.
- Logs.
- Mensageria.
- Configurações de ambiente.
- Deploy.


## Padrões Arquiteturais

Exemplos:

- Repository Pattern.
- Service Layer.
- Dependency Injection.
- Eventos.
- Filas.
- Estratégias de validação.


---

# Estrutura dos Documentos

Utilize [`TEMPLATE.md`](./TEMPLATE.md) para iniciar a documentação de um componente. O README define a categoria e as regras gerais; cada documento específico deve refletir o estado real do componente.

Cada componente deve possuir sua própria documentação Markdown seguindo o padrão:

```markdown
# Nome do Componente

## 1. Objetivo

Descrever a finalidade do componente e qual problema resolve.


## 2. Responsabilidade

Definir claramente:

- O que o componente deve fazer.
- O que não pertence a sua responsabilidade.


## 3. Localização

Informar onde está implementado:

Exemplo:
