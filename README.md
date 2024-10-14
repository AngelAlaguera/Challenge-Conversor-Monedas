## Conversor de Monedas - Challenge Alura & Oracle

Este proyecto implementa un conversor de monedas utilizando la API [`exchangerate-api`](https://app.exchangerate-api.com/dashboard) en Java. Es un desafío completado como parte del programa de especialización Backend con Java de Alura y Oracle.

**Descripción:**

El conversor de monedas permite a los usuarios:

- Ingresar la moneda de origen y la moneda a la que desean convertir.
- Introducir la cantidad a convertir.
- Obtener la cantidad convertida.

**Características:**

- **Búsqueda flexible:** El usuario puede ingresar la moneda de origen y la moneda de destino usando:
    - **Abreviaturas:** USD, EUR, VES, etc.
    - **Nombres de países o regiones:** Venezuela, Colombia, China, etc.
- **Interfaz amigable:** El programa proporciona mensajes informativos para guiar al usuario durante el proceso de conversión.

**Tecnologías:**

- Java
- API [`exchangerate-api`](https://app.exchangerate-api.com/dashboard)
- JSON parsing
- Estructuras de datos

**Estructura del proyecto:**

```
DESAFIO-CONVERSOR-MONEDAS/
├── src/
│   └── com/
│       └── exchangerateapi/
│                     ├── conexion/
│                     │      └── ConeccionApi.java  // Clase para conectar con la API.
│                     ├── modelos/
│                     │      └── Moneda.java       // Clase que representa una moneda.
│                     │      └── JsonParser.java   // Clase para parsear datos JSON.
│                     │      └── PaisMoneda.java    // Clase para obtener abreviaturas de monedas.
│                     ├── monedaspais/
│                     │      └── monedasPais.json // Archivo JSON con información de monedas y países.
│                     └── principal/
│                            └── App.java         // Clase principal del proyecto.
└── README.md 
```
**El proyecto se organiza de la siguiente manera:** 

- .idx:
    - .nix: Archivo que define los paquetes necesarios de Java y las extensiones de VS Code.
- .vscode:
    - settings.json: Configura las estructuras de carpetas, paquetes y herramientas de autocompletado.
- bin: Contiene las clases bitcode necesarias para el intérprete de Java.
    - lib: Almacena los paquetes .jar que no están disponibles en Project IDX.
- src: Contiene los archivos .java del proyecto de conversión de monedas.

**Uso:**
1. Ejecutar la clase `App.java`.
2. El programa solicitará la moneda de origen y la moneda a la que se desea convertir.
    - Puede ingresar la abreviatura de la moneda (USD, EUR, etc.) o el nombre del país o región.
3. Se le pedirá que ingrese la cantidad a convertir.
4. El conversor mostrará el resultado de la conversión.

**Instalación:**

1. Clonar el repositorio: `git clone [https://github.com/AngelAlaguera/Challenge-Conversor-Monedas.git]`
2. Abrir el proyecto en un IDE Java o Project IDX (VS Code en la nube).
3. Ejecutar la clase `App.java`.

**Agradecimientos:**

Agradezco a Alura y Oracle por la oportunidad de participar en este programa de especialización y aprender sobre desarrollo backend con Java. He aprendido mucho sobre estas tecnologías, incluyendo:

- Consumir APIs
- Leer, manipular y escribir JSON
- Utilizar estructuras de datos
- Implementar funciones básicas de programación.

**Próximos pasos:**

- Implementar una interfaz gráfica para el conversor.
- Agregar más funcionalidades, como el historial de conversiones.
- Integrar el conversor con otras aplicaciones.

**Contribuciones:**

Las contribuciones son bienvenidas. 
- Puedes enviar un pull request con nuevas funcionalidades o correcciones. 
- Los problemas o sugerencias se pueden reportar en la sección "Issues" del repositorio.
