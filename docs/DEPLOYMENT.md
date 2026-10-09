# Build e Distribuição

> **Escopo:** o repositório produz uma biblioteca Android (`:componentes`) e um aplicativo de demonstração (`:app`). Não foram encontrados servidor, backend, banco de dados ou ambientes de implantação de aplicação neste projeto.
>
> **Estado atual:** a versão `1.0.29` foi enviada ao JitPack e seu build foi concluído com sucesso em 2026-10-09. Esse resultado confirma a publicação desta versão, mas não substitui a revisão e aprovação humana exigidas para releases futuros.

## 1. Artefatos

| Módulo | Artefato | Uso |
|---|---|---|
| `:componentes` | Android Archive (AAR) de release | Distribuição da biblioteca de componentes a aplicativos Android |
| `:app` | APK de debug | Instalação do aplicativo de demonstração em dispositivo/emulador durante desenvolvimento |

O aplicativo de demonstração não está configurado neste repositório com assinatura de produção ou processo de publicação em loja. Não o trate como um aplicativo pronto para distribuição pública.

## 2. Pré-requisitos

- JDK 17 para o Gradle Wrapper 9.6.0 e o Android Gradle Plugin 9.4.1.
- Android SDK Platform 36 e dependências resolvíveis pelos repositórios Google Maven e Maven Central.
- Para instalar o app de demonstração: dispositivo ou emulador Android configurado.

Os módulos declaram `minSdk 23`; o app de demonstração declara `targetSdk 36`. Esses valores são configurações de build, não uma política de suporte documentada.

## 3. Build local

Execute a partir da raiz do repositório.

### Windows PowerShell

```powershell
.\gradlew.bat :componentes:assembleRelease
.\gradlew.bat :app:assembleDebug
```

### macOS/Linux

```bash
./gradlew :componentes:assembleRelease
./gradlew :app:assembleDebug
```

Artefatos esperados:

- AAR: `componentes/build/outputs/aar/componentes-release.aar`
- APK de demonstração: `app/build/outputs/apk/debug/app-debug.apk`

Para instalar a demonstração em um dispositivo/emulador conectado:

```powershell
.\gradlew.bat :app:installDebug
```

```bash
./gradlew :app:installDebug
```

O build de release da biblioteca declara `minifyEnabled false`. A existência dos comandos e caminhos descreve a configuração Gradle; cada release deve confirmar que o build concluiu e que o artefato esperado foi gerado. Para os resultados do release `1.0.29`, consulte a seção correspondente abaixo.

## 4. Configuração de publicação encontrada

`componentes/build.gradle` declara a publicação Maven `release` com os seguintes valores:

| Campo | Valor configurado |
|---|---|
| `groupId` | `com.github.Concyline` |
| `artifactId` | `Componentes` |
| `version` | `1.0.29` |
| Artefato associado | AAR produzido por `bundleReleaseAar` |

### Regra de incremento da versão

Em cada novo deploy/release da biblioteca, incremente em **1** o último segmento numérico de `version` no bloco `publishing` de `componentes/build.gradle`, mantendo os demais segmentos inalterados. Exemplo: `1.0.28` passa para `1.0.29`; o valor seguinte será `1.0.30`.

Antes de gerar o artefato, confirme que a versão foi incrementada em relação à publicação anterior e que o valor atualizado é o usado no build. Essa regra documenta a instrução do projeto; não altera automaticamente o arquivo Gradle nem confirma que houve publicação.

O repositório também contém `jitpack.yml`, que indica JDK 17. A publicação da versão `1.0.29` foi confirmada no JitPack; isso não estabelece por si só todas as etapas de aprovação ou operação para releases futuros.

Não há repositório remoto de publicação configurado no bloco `publishing` consultado. Para o release `1.0.29`, o JitPack construiu o commit apontado pela tag e disponibilizou a coordenada Maven. Para releases futuros:

- não presuma que um build local equivale a publicação remota;
- confirme a revisão e aprovação humana, atualize a versão e envie a tag aprovada;
- consulte o build log do JitPack e confirme a coordenada/artefatos antes de declarar a publicação concluída;
- valide a resolução da dependência em um aplicativo consumidor quando aplicável.

### Release confirmado: `1.0.29`

Em 2026-10-09, a versão `1.0.29` foi preparada, enviada e compilada pelo JitPack:

| Evidência | Resultado |
|---|---|
| Commit de release | `935babf` (`Release 1.0.29`) |
| Branch remota | `master` atualizada para `935babf` |
| Tag remota | `1.0.29`, apontando para `935babf` |
| Coordenada publicada | `com.github.Concyline:Componentes:1.0.29` |
| Ambiente JitPack | Oracle JDK `17.0.12`; Gradle Wrapper `9.6.0` |
| Build do JitPack | `BUILD SUCCESSFUL`; código de saída `0` |
| Artefatos confirmados | `Componentes-1.0.29.aar`, POM e sources JAR |
| Avisos | Recursos Gradle depreciados e dois avisos de anotação de depreciação em `DotLoader`; não impediram o build |

O commit incluiu somente `componentes/build.gradle` (versão `1.0.28` → `1.0.29`), `gradle/libs.versions.toml` (AGP `9.0.0` → `9.4.1`) e `gradle/wrapper/gradle-wrapper.properties` (Gradle `9.1.0` → `9.6.0`). O diff desses arquivos foi revisado antes do commit. Alterações locais em `.idea/` e `docs/` ficaram fora do commit.

Validações executadas para o release:

- Localmente, `:componentes:assembleRelease` e `:app:assembleDebug` concluíram com sucesso usando o JBR 25 do Android Studio.
- `:componentes:testDebugUnitTest` não tinha fontes de teste (`NO-SOURCE`).
- No JitPack, o build da tag foi concluído com sucesso sob JDK 17 e Gradle 9.6.0, conforme `jitpack.yml`.

O artefato AAR foi publicado no JitPack. Não foi registrada nesta tarefa uma integração de consumo de ponta a ponta por um aplicativo externo.

## 5. Ambientes e promoção

| Ambiente/etapa | Estado documentado |
|---|---|
| Desenvolvimento local | Confirmado: Gradle permite compilar a biblioteca e o app de demonstração localmente. |
| Homologação da biblioteca | Pendente: não há ambiente ou fluxo de homologação identificado. |
| Produção/distribuição da biblioteca | Confirmado para `1.0.29`: tag enviada e AAR construído/disponibilizado pelo JitPack. O procedimento de aprovação para releases futuros ainda deve ser seguido. |
| Distribuição do app de demonstração | Não configurada: não foi identificado processo de assinatura ou publicação em loja. |

Branches como `develop`, `release` ou `main`, bancos por ambiente, publicação contínua, responsáveis e aprovações não estão definidos por evidência disponível e não são presumidos aqui.

## 6. Verificações antes de disponibilizar uma versão

Como verificações técnicas mínimas, antes de promover um AAR:

1. Revisar as alterações e incrementar o último segmento numérico de `version` em 1, conforme a regra acima.
2. Compilar `:componentes:assembleRelease` com JDK 17 e Android SDK Platform 36.
3. Executar `:componentes:testDebugUnitTest` quando existirem testes; a cobertura automatizada deve ser conferida separadamente.
4. Confirmar que `componentes/build/outputs/aar/componentes-release.aar` foi gerado.
5. Validar que um aplicativo consumidor consegue resolver e integrar a coordenada da versão, pelo canal oficialmente aprovado.

As etapas acima descrevem verificações técnicas; não substituem as aprovações humanas. Para `1.0.29`, a publicação também foi verificada pelo resultado do JitPack e pela presença dos artefatos reportados no build log.

Para o APK de demonstração, `:app:assembleDebug` produz apenas o artefato de desenvolvimento. Release assinado, keystore, configuração de loja, trilha de testes e publicação do app estão pendentes de definição.

## 7. Rollback e recuperação

Não foi encontrado procedimento de rollback de publicação. A estratégia depende do canal que a equipe confirmar:

- **Consumidores da biblioteca:** a recuperação deve ser definida pelo responsável pelo release, por exemplo, orientar consumidores a fixar novamente uma versão previamente validada. Não presuma que um pacote publicado possa ser substituído ou removido.
- **App de demonstração:** não existe distribuição de produção configurada neste repositório; rollback de loja não se aplica ao fluxo atual identificado.
- **Build local:** corrija ou reverta a alteração em uma revisão controlada e gere/valide novamente o artefato; não substitua arquivos distribuídos sem o processo aprovado.

Política de versões suportadas, compatibilidade de API, retirada de releases e comunicação a consumidores permanecem pendentes.

## 8. Itens que exigem confirmação

- Aprovação humana, responsáveis e eventuais etapas formais adicionais para releases futuros.
- Repositório ou pipeline de publicação remota, se existir fora dos arquivos examinados.
- Política de compatibilidade, versões suportadas, rollback e comunicação a consumidores.
- Se o aplicativo de demonstração deve ser assinado ou publicado externamente.

Até que esses pontos sejam confirmados, trate a saída deste guia como build local de artefatos, não como autorização ou procedimento de implantação em produção.
