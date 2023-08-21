### :brazil: Semana 3&4

O desafio dessa semana foi gerar— de de forma automática, a descrição para um destino quando esse campo vir
nulo ou em branco no corpo da requisição. Para isso, realizei a integração com a API do ChatGPT e, ao receber uma requisição
para cadastrar um destino, uma verificação era feita para validar o campo do `description` no corpo da requisição. Caso
essa informação estivesse faltando, uma requisição era feita para a API do ChatGPT com um _prompt_ era criado a partir
de um _template_ inserido na classe na [classe]() responsável por esse regra de negócio. Se tudo ocorrer bem, o campo 
`description` será preenchido com a primeira resposta retornada pela API e armazenado na base de dados, caso contrário
uma exceção é lançada. Se o campo `description` vier preenchido, a regra de negócio padrão é executada.

 ### :us: Week 3&4 
This week's challenge was to automatically generate the description for a destination when this field sees
null or blank in the request body. For this, I performed the integration with the ChatGPT API and, when receiving a request
to register a destination, a check was made to validate the `description` field in the request body. Case
this information is missing, a request was made to the ChatGPT API with a _prompt_ created from
from a _template_ inserted into the class in the [class]() responsible for this business rule. If all goes well, the field
`description` will be filled with the first response returned by the API and stored in the database, otherwise
an exception is thrown. If the `description` field is filled in, a standard business rule is executed.
