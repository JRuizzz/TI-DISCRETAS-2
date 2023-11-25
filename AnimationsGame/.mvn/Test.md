| Clase | Método | Escenario | Valores de Entrada | Resultado Esperado |
|-------|--------|-----------|--------------------|--------------------|
| Grafo | agregarVertice | Agregar un vértice al grafo | ID, coordenadas (x, y) del vértice | El vértice se agrega con éxito |
| Grafo | agregarVerticeConCoordenadasNegativas | Agregar un vértice con coordenadas negativas | ID, coordenadas (x, y) del vértice | El vértice se agrega con éxito |
| Grafo | agregarVerticeRepetido | Agregar un vértice repetido al grafo | ID, coordenadas (x, y) del vértice | El vértice se agrega con éxito |
| Grafo | agregarArista | Agregar una arista al grafo | Vértice de inicio, vértice de fin, peso | La arista se agrega con éxito |
| Grafo | agregarAristaConPesoNegativoAlternativo | Agregar una arista con peso negativo | Vértice de inicio, vértice de fin, peso | La arista no se agrega correctamente |
| Grafo | agregarAristaConVerticeNulo | Agregar una arista con un vértice nulo | Vértice de inicio, vértice nulo, peso | La arista no se agrega correctamente |
| Grafo | dijkstra | Calcular el camino más corto con Dijkstra | Vértice de inicio, vértice de fin | Lista de posiciones del camino |
| Grafo | dijkstraGrafoPequeno | Calcular el camino más corto en un grafo pequeño con Dijkstra | Vértice de inicio, vértice de fin | Lista de posiciones del camino |
| Grafo | dijkstraGrafoGrande | Calcular el camino más corto en un grafo grande con Dijkstra | Vértice de inicio, vértice de fin | Lista de posiciones del camino |
