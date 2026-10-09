# Template de Funcionalidade (Feature)

Este documento serve como **modelo oficial** para a documentação de qualquer nova funcionalidade (feature) no projeto. Ao iniciar uma nova tarefa, utilize este template para garantir que todas as informações necessárias sejam registradas de forma padronizada.

> **⚠️ OBRIGATÓRIO:** Todo agente de IA deve atualizar o campo **Status da Funcionalidade** abaixo sempre que houver qualquer movimentação no processo de desenvolvimento ou validação da feature.

---
## 🚦 Status da Funcionalidade
- [ ] Criada
- [ ] Em Andamento
- [ ] Finalizada

---

## 📋 Informações Básicas
- **Título da Funcionalidade:** [Título Curto e Descritivo]
- **Card/Issue:** #[Número do Card]
- **Data de Início:** [DD/MM/AAAA]
- **Cliente/Responsável:** [Nome do Cliente / Administrador]
- **Etiquetas:** [Ex: Melhoria, Urgente, Bug, etc.]

## 📝 Descrição
[Descrição detalhada do problema ou necessidade que motivou esta funcionalidade.]

## 🔄 Passos para Reproduzir / Cenário de Uso
[Descreva o fluxo ou os passos necessários para validar a funcionalidade.]

## 📁 Arquivos e Documentação Relacionada
- [Link ou nome do arquivo de exemplo, ex: XML, documento técnico]
- [Referências a outras notas, módulos ou documentos]

## 💡 Informações Adicionais
[Notas técnicas, limitações, ou comportamentos esperados.]

## 🤖 Descobertas IA / Sugestões para Desenvolvimento
[Documente aqui achados relevantes durante a investigação, descobertas sobre o funcionamento atual do código relacionado à solicitação, e sugestões de resolução técnica baseadas nos projetos e na solicitação informada.]

---

## ✅ Checklist de Execução

### Análise de Requisito
- [ ] Detalhar o cenário da implementação

### Desenvolvimento
- [ ] Criar uma nova branch com o nome `Feature/{card_number}` a partir da branch `Develop`
- [ ] Desenvolver a implementação solicitada
- [ ] Testar os possíveis cenários após as alterações feitas no projeto
- [ ] Enviar a branch para o servidor
- [ ] Mover o card para a fila de testes

### QA - Controle de Qualidade
- [ ] Baixar a branch referente à solicitação
- [ ] Fazer o merge na branch `Homolog`
- [ ] Realizar os testes e validar a melhoria solicitada
- [ ] Fazer o merge da branch (`Feature/{card_number}`) no `Develop`
