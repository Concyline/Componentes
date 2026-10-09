# Projetos de Referência

Esta pasta contém os projetos, recortes de repositórios e conjuntos de arquivos utilizados como referência para consulta e treinamento operacional dos agents.

Cada projeto deve permanecer isolado em seu próprio diretório:

```text
PROJECTS/
├── PROJECT_001/
│   ├── README.md
│   ├── .reference.yml
│   └── arquivos-do-projeto/
└── PROJECT_002/
    ├── README.md
    ├── .reference.yml
    └── arquivos-do-projeto/
```

Para cadastrar um projeto novo:

1. crie uma pasta com identificador único dentro de `PROJECTS/`;
2. copie `TEMPLATE.md` para essa pasta como `README.md`;
3. copie `REFERENCE_METADATA_TEMPLATE.yml` como `.reference.yml`;
4. adicione os arquivos sanitizados do projeto;
5. atualize `../CATALOG.md`.

Os modelos não devem ser modificados para representar um projeto específico; copie-os e preencha as cópias dentro da pasta do projeto.

Antes de adicionar um projeto, consulte as regras de segurança, privacidade, licenciamento e classificação em [`../README.md`](../README.md).

Os projetos armazenados aqui são fontes auxiliares de consulta. Eles não fazem parte automaticamente do projeto atual e não devem ser copiados, executados ou tratados como padrão oficial sem validação.
