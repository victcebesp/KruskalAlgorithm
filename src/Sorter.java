public class Sorter {

    public void sort(Edge[] edges) {

        int m11 = 1;
        int n = edges.length;
        Edge[] aux = new Edge[n];
        while(m11 < n){
            int p1 = 0;
            int l1 = p1 + m11;
            int p2 = l1;
            int l2 = p2+m11;
            int pla = 0;
            while( pla < n){
                if(l1 > n-1){
                    l1 = n;
                }

                if( l2 > n-1){
                    l2 = n;
                }
                while(p1 < l1 && p2 < l2){

                    if(edges[p1].getCost() < edges[p2].getCost()){

                        aux[pla] = edges[p1];
                        p1++;

                    }else{

                        aux[pla] = edges[p2];
                        p2++;
                    }
                    pla++;
                }
                while(p1 < l1){
                    aux[pla] = edges[p1];
                    p1++;
                    pla++;
                }
                while(p2 < l2){
                    aux[pla] = edges[p2];
                    p2++;
                    pla++;
                }
                p1 = p2;
                l1 = p2 + m11;
                p2 = l1;
                l2 = p2+m11;
            }
            m11 = 2*m11;
            for (int i = 0; i < n; i++) {
                edges[i] = aux[i];
            }
        }
    }

}
