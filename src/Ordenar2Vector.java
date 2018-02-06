public class Ordenar2Vector {

    public void ordena(Edge[] v) {

        Edge [] vecs = new Edge[v.length];
        selcuadra(v, vecs, v.length);

        for (int i = 0; i < v.length; i++) v[i] = vecs[i];
    }

    private void selcuadra(Edge[] vec, Edge[] vecs, int n) {
        int npart = (int) Math.sqrt(n);
        int nelement = npart;
        if (nelement*npart < n){
            nelement++;
            if (npart*nelement < n){
                npart++;
            }
        }

        int [] aux = new int[npart];
        for (int part = 0; part < npart; part++) {
            selpart(vec, n, aux, nelement, part);
        }

        for (int m = 0; m < n; m++) {
            int menor = aux[0];
            int part = 0;
            for (int e = 1; e < npart; e++) {
                if (aux[e] < menor){
                    menor = aux[e];
                    part = e;
                }
            }
            vecs[m] = menor;
            selpart(vec, n, aux, nelement, part);
        }
    }

    private void selpart(Edge [] vec, int n, Edge[] aux, int nele, int part) {
        int primero = part*nele;
        int ultimo = (nele*(part+1)-1) < n - 1 ? nele*(part+1) : n;
        int pos = primero;
        Edge menor = vec[primero];
        for (int elem = primero + 1; elem < ultimo; elem++) {
            if (vec[elem].getCost() < menor.getCost()) {
                menor = vec[elem];
                pos = elem;
            }
        }
        aux[part] = menor;
        vec[pos] = null;
    }
}