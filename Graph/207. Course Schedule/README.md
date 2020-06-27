![Directed_acyclic_graph_2 svg](https://user-images.githubusercontent.com/66917271/85914702-847c1a00-b80e-11ea-924e-48a1a432dc78.png)


Kahn's algorithm

L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edges
while S is non-empty do

remove a node n from S
add n to tail of L
for each node m with an edge e from n to m do
remove edge e from the graph
if m has no other incoming edges then
insert m into S
if graph has edges then
return error (graph has at least one cycle)
else
return L (a topologically sorted order)
