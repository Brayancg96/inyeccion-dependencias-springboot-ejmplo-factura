
<section>
  <h1>📚 Proyecto de Estudio: Inyección de Dependencias con Ejemplo de Factura en Spring Boot</h1>

  <p>
    Este proyecto tiene como objetivo comprender a fondo el principio de <strong>Inyección de Dependencias (DI)</strong> en 
    <strong>Spring Boot</strong>, utilizando un escenario práctico de una <strong>factura</strong> relacionada con 
    un <em>cliente</em>, <em>productos</em> e <em>ítems</em>. Además, se estudia el <strong>ciclo de vida de los componentes</strong> 
    mediante las anotaciones <code>@PostConstruct</code> y <code>@PreDestroy</code>.
  </p>

  <hr />

  <h2>🎯 Objetivos de aprendizaje</h2>
  <ul>
    <li>Comprender cómo funciona la inyección de dependencias en Spring Boot.</li>
    <li>Modelar un escenario de negocio con <strong>Factura, Cliente, Producto e Ítems</strong>.</li>
    <li>Relacionar objetos mediante servicios e interfaces con anotaciones como <code>@Service</code> y <code>@Component</code>.</li>
    <li>Analizar el ciclo de vida de los beans con <code>@PostConstruct</code> y <code>@PreDestroy</code>.</li>
  </ul>

  <h2>🧱 Escenario: Factura</h2>
  <p>
    El proyecto representa una factura donde un <strong>Cliente</strong> puede tener varios <strong>Productos</strong>, 
    organizados en <strong>Ítems</strong>, que a su vez conforman la <strong>Factura</strong>. 
    Este modelo permite poner en práctica la inyección de dependencias y la composición de objetos gestionados por Spring.
  </p>

  <pre><code class="language-java">// Entidad Cliente
@Component
public class Cliente {
    private String nombre;
    private String apellido;

    // Getters/Setters
}

// Entidad Producto
@Component
public class Producto {
    private String nombre;
    private Double precio;

    // Getters/Setters
}

// Item de la factura
public class ItemFactura {
    private Producto producto;
    private int cantidad;

    public Double calcularImporte() {
        return producto.getPrecio() * cantidad;
    }
}
</code></pre>

  <h2>📦 Factura y sus dependencias</h2>
  <pre><code class="language-java">@Component
public class Factura {

    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List&lt;ItemFactura&gt; items;

    private String descripcion;

    @PostConstruct
    public void inicializar() {
        this.descripcion = "Factura para cliente con productos";
        System.out.println("🚀 Bean Factura inicializado");
    }

    @PreDestroy
    public void destruir() {
        System.out.println("🧹 Bean Factura destruido antes de apagar el contexto Spring");
    }

    // Getters/Setters
}
</code></pre>


  <h2>⚙️ Ciclo de vida de los componentes</h2>
  <p>
    Spring gestiona el ciclo de vida de los beans. Con <code>@PostConstruct</code> se inicializan valores o lógica 
    justo después de que el bean es creado y sus dependencias inyectadas. 
    Con <code>@PreDestroy</code> se ejecuta código de limpieza antes de que el contexto de la aplicación se cierre.
  </p>

  <h3>Ejemplo en consola</h3>
  <pre><code>
🚀 Bean Factura inicializado
🧹 Bean Factura destruido antes de apagar el contexto Spring
</code></pre>


  <h2>📝 Conclusiones</h2>
  <ul>
    <li>La <strong>inyección de dependencias</strong> permite desacoplar los componentes y delegar en Spring la creación de objetos.</li>
    <li>Un escenario realista como una <strong>Factura</strong> facilita entender cómo los objetos se relacionan entre sí.</li>
    <li>Las anotaciones <code>@PostConstruct</code> y <code>@PreDestroy</code> ayudan a manejar el ciclo de vida de los beans.</li>
  </ul>

  <hr />
  <p><em>Este proyecto fue desarrollado con fines educativos para comprender la inyección de dependencias y el ciclo de vida de los componentes en Spring Boot. Si te resultó útil, ¡déjame una ⭐ en el repositorio!</em></p>
</section>
