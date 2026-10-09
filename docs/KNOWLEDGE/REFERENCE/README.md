# Projetos de Referência

Esta pasta contém **outros projetos, partes de projetos, exemplos de código e artefatos técnicos utilizados como fonte de consulta para agents e desenvolvedores**.

Seu objetivo é fornecer contexto comparativo e exemplos práticos para auxiliar:

- investigação de soluções técnicas;
- identificação de padrões de implementação;
- compreensão de estruturas de código;
- comparação entre abordagens;
- criação de protótipos;
- treinamento operacional e contextual dos agents por meio de consulta à base.

## O que esta pasta representa

Os conteúdos desta pasta formam uma **biblioteca de projetos de referência**. Eles podem ser projetos completos, recortes de repositórios, arquivos `.cs`, `.xml`, configurações, exemplos de integração ou outros materiais técnicos autorizados.

Esses conteúdos são fontes auxiliares de conhecimento. Eles **não representam automaticamente**:

- o código do projeto atual;
- a arquitetura oficial do projeto atual;
- regras de negócio vigentes;
- padrões obrigatórios de implementação;
- dependências aprovadas;
- contratos públicos ou configurações de ambiente.

## Como o agent deve utilizar esta pasta

Antes de reutilizar qualquer conteúdo, o agent deve:

1. identificar a finalidade e o contexto do projeto de referência;
2. consultar o `README.md` e os metadados do material;
3. verificar compatibilidade com a arquitetura, stack e versão do projeto atual;
4. avaliar segurança, privacidade, licença e autorização de uso;
5. separar o que é exemplo do que é decisão oficial;
6. adaptar a solução ao projeto atual;
7. validar a implementação após a adaptação.

O agent não deve copiar, executar ou incorporar conteúdo automaticamente apenas porque ele existe nesta pasta.

O fluxo detalhado de treinamento operacional está documentado em [`TRAINING.md`](./TRAINING.md).

## Fluxo de inclusão de um projeto

O cadastro de uma nova referência deve seguir este fluxo:

1. Confirmar a necessidade de incluir o projeto.
2. Confirmar origem, licença ou autorização de uso.
3. Sanitizar credenciais, dados pessoais e configurações sensíveis.
4. Criar uma pasta exclusiva dentro de `PROJECTS/`.
5. Copiar `TEMPLATE.md` para a pasta do projeto como `README.md`.
6. Copiar `REFERENCE_METADATA_TEMPLATE.yml` como `.reference.yml`.
7. Preencher finalidade, tecnologias, limitações, tags e escopo de uso.
8. Revisar o conteúdo quanto a segurança e privacidade.
9. Atualizar `CATALOG.md`.
10. Validar que o projeto permanece isolado e não foi misturado ao código atual.

Projetos incompletos ou ainda não revisados devem permanecer com status `DRAFT` e não devem ser usados como referência aprovada.

## Organização recomendada

Quando houver múltiplos projetos, mantenha cada fonte isolada:

```text
REFERENCE/
├── README.md
├── CATALOG.md
├── TRAINING.md
└── PROJECTS/
    ├── README.md
    ├── PROJECT_001/
    │   ├── README.md
    │   ├── .reference.yml
    │   └── arquivos-do-projeto/
    └── PROJECT_002/
        ├── README.md
        ├── .reference.yml
        └── arquivos-do-projeto/
```

Os projetos devem ser armazenados exclusivamente dentro de `PROJECTS/`. Cada projeto deve possuir um `README.md` com, no mínimo:

- identificador e nome;
- finalidade;
- origem;
- licença ou autorização de uso;
- tecnologias e versões;
- tags de pesquisa;
- partes relevantes para consulta;
- limitações e incompatibilidades conhecidas;
- dados que foram removidos ou anonimizados.

Use os modelos em [`PROJECTS/TEMPLATE.md`](./PROJECTS/TEMPLATE.md) e [`PROJECTS/REFERENCE_METADATA_TEMPLATE.yml`](./PROJECTS/REFERENCE_METADATA_TEMPLATE.yml) para manter os cadastros consistentes.

## Segurança, privacidade e licenciamento

É proibido armazenar nesta pasta:

- senhas, tokens, chaves de API ou certificados privados;
- dados pessoais ou dados reais de clientes sem autorização;
- arquivos de ambiente com valores sensíveis;
- código de terceiros sem licença ou autorização compatível;
- informações confidenciais que não sejam necessárias para a finalidade de referência.

Antes de adicionar um projeto, o responsável deve sanitizar o conteúdo e confirmar que seu uso é permitido.

## Classificação dos conteúdos

Cada projeto ou artefato deve indicar seu estado:

- `REFERENCE`: material disponível para consulta;
- `APPROVED_REFERENCE`: material revisado e aprovado para servir como referência;
- `DRAFT`: material ainda não revisado;
- `RESTRICTED`: material sujeito a restrições adicionais;
- `DEPRECATED`: material mantido apenas por valor histórico;
- `REMOVED`: referência retirada e não utilizável.

## Regra principal

> Os conteúdos de `KNOWLEDGE/REFERENCE/` são projetos e artefatos auxiliares para consulta e treinamento operacional dos agents. Eles não fazem parte automaticamente do projeto atual, não substituem a documentação oficial e não devem ser tratados como decisões oficiais sem validação explícita.

## Limites da referência

Esta biblioteca não altera o comportamento do agent por treinamento permanente do modelo. Ela fornece material que o agent pode consultar durante uma tarefa, por busca direta, catálogo ou mecanismo de recuperação disponível no ambiente. A qualidade da consulta depende da organização, dos metadados, da sanitização e da atualização dos projetos cadastrados.
