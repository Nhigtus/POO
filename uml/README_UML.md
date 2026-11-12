# Diagramas UML - Proyecto POO (Entrega 2)

Estos diagramas salen del **código real** que está en `src/`, no de una idea de cómo debería ser.
No inventé relaciones que el código todavía no tiene.

## Archivos

| Archivo | Qué muestra | ¿Para qué sirve? |
|---|---|---|
| `01_Diagrama_Clases_Completo.puml` | Modelo + controladores + interfaz `ICRUD` | Vista técnica completa del sistema |
| `02_Diagrama_Clases_Dominio.puml` | Solo el modelo de dominio y sus relaciones | **Este es el más limpio para entregar como diagrama de clases** |
| `03_Diagrama_Paquetes_MVC.puml` | Paquetes `modelo`, `controlador`, `vista`, `GUI` | Explicar la arquitectura MVC |
| `04_Diagrama_Clases_GUI.puml` | Ventanas Swing, `Sesion` y controladores | Mostrar la capa de presentación |

También dejé los `.png` generados de cada uno.

## Relaciones que sí existen en el código

| Relación | Tipo | Dónde está en el código |
|---|---|---|
| `Producto <|-- ProductoPerecedero` | Herencia | `ProductoPerecedero extends Producto` |
| `Pais ◆── Ubicacion_Corporativa` | Composición | `Pais.ciudades` + `Ubicacion_Corporativa.setPais()` |
| `Ubicacion_Corporativa ◇── Almacenes` | Agregación | `Ubicacion_Corporativa.almacenes` + `Almacenes.setCiudad()` |
| `Almacenes ◆── Zona` | Composición | `Almacenes.zonas` + `Zona.almacen` |
| `Zona ◇── Producto` | Agregación | `Zona.productos` + `Zona.agregarProducto()` |
| `Controlador_X ..|> ICRUD` | Realización | Los 6 controladores implementan `ICRUD` |
| `Controlador_X --> Modelo_X` | Asociación | Cada controlador tiene su `ArrayList` estático del modelo |

## Lo que todavía NO se debe dibujar

En la Entrega 2:

- `Movimiento_Logistico` guarda `producto_involucrado` y `operario_responsable` como `String`.
- `Usuario` guarda `almacen_asignado` como `String`.
- No existen todavía las subclases `Gerente`, `Operario` ni `Administrador`.

Por eso el diagrama no muestra asociaciones por objeto entre `Movimiento_Logistico` y `Producto`/`Usuario`, ni herencia de usuarios. Eso corresponde a los pasos 5 y 6. Si en la sustentación te piden el código que respalde el diagrama, el diagrama actual sí coincide con el código.

## Cómo abrirlos en NetBeans

Ya tienes instalado el plugin de PlantUML en NetBeans (está en `.netbeans/31/modules/ext/org.netbeans.modules.plantumlnb`).

1. Abre el proyecto en NetBeans.
2. Abre cualquier archivo `.puml` de la carpeta `uml/`.
3. Usa la vista previa de PlantUML o clic derecho para generar/exportar la imagen.

También puedes regenerar los PNG desde terminal:

```bash
cd /home/nhigtus/NetBeansProjects/POO
java -Djava.awt.headless=true \
  -jar /home/nhigtus/.netbeans/31/modules/ext/org.netbeans.modules.plantumlnb/1/net-sourceforge-plantuml/plantuml.jar \
  -tpng -o uml uml/*.puml
```

## Para la entrega final

El PDF pide el diagrama final en **ArgoUML o StarUML**. Los `.puml` son la fuente y la guía; para el entregable formal puedes:

- Redibujar `02_Diagrama_Clases_Dominio.puml` en StarUML/ArgoUML (es el más corto y claro), o
- Usar `01_Diagrama_Clases_Completo.puml` si quieres incluir controladores.

No recomiendo entregar solo el PNG de PlantUML si el profesor exige el archivo de StarUML/ArgoUML. Pero el contenido y las relaciones ya están listos; solo es pasarlo a la herramienta.
