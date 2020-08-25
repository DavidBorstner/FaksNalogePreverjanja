import java.util.*;

public class Drevo23<Tip extends Comparable> implements Seznam<Tip> {

    class Element23 {

        public Tip a, b, c;
        public Element23 L, S, D, E;

        public Element23(Tip e) {
            this.a = e;
            this.b = null;
            this.L = null;
            this.S = null;
            this.D = null;
            this.E = null;
        }

        public Element23() {
            a = null;
            b = null;
            c = null;
            L = null;
            S = null;
            D = null;
            E = null;
        }

        public Element23(Tip e, Tip x) {
            this.a = e;
            this.b = x;
            this.L = null;
            this.S = null;
            this.D = null;
            this.E = null;
        }

    }

    Element23 rootNode;
    int n = 0;
    boolean pog = false;
    boolean vstavi = false;
    Element23 zac;

    public void D23() {
        rootNode = new Element23();
        n = 0;
        vrni = new ArrayList<Tip>();
    }

    public boolean primerjava(Tip ena, Tip dva) {
        int prvi = Integer.parseInt((String) ena);
        int drugi = Integer.parseInt((String) dva);
        if (prvi > drugi) {
            return true;
        } else {
            return false;
        }
    }

    public Element23 insert(Tip e, Element23 node) {
        if (node == null || node.a == null) { // pogleda če sploh je not kej
            node = new Element23(e);
        } else if (node.L == null) { // če obstaja L pomen da so otroci
            if (node.b == null) { // če bja ni pomen da ga lahk kr tk not damo
                node.b = e;
                if (primerjava(node.a, node.b)) {
                    Tip zac = node.b;
                    node.b = node.a;
                    node.a = zac;
                }
            } else { // če je b pomen da sta a in b polna kar pomen, da je treba razdelit na otroke
                if (primerjava(node.a, e)) { // pogleda če je prvi element večji od eja
                    node.L = insert(e, node.L);
                    node.S = insert(node.b, node.S);
                    node.b = null;
                } else if (primerjava(e, node.b)) { // pogleda če je e večjo od drugega elementa
                    node.L = insert(node.a, node.L);
                    node.S = insert(e, node.S);
                    node.a = node.b;
                    node.b = null;
                } else { // če je e vmes med obema elemntoma
                    node.L = insert(node.a, node.L);
                    node.S = insert(node.b, node.S);
                    node.b = null;
                    node.a = e;
                }
            }
        } else if (node.a != null && node.L != null && velikost(node) != 2) { // če a ni null in L obstaja pomen,da mamo otroke
            if (primerjava(node.a, e)) { // če je prvi element roota manjši od eja
                if (node.L.b == null) { // če je b null lahko kr tak vstavmo
                    node.L.b = e;
                    if (primerjava(node.L.a, node.L.b)) {
                        node.L.b = node.L.a;
                        node.L.a = e;
                    } else {
                        node.L.b = e;
                    }
                } else { // če b ni null pol ne mormo kr tk not dat
                    if (velikost(node.S) != 2) {
                        if (primerjava(node.L.a, e)) {
                            node.L.c = node.L.b;
                            node.L.b = node.L.a;
                            node.L.a = e;

                            node.S.b = node.a;
                            if (primerjava(node.S.a, node.S.b)) {
                                node.S.b = node.S.a;
                                node.S.a = node.a;
                            }

                            node.a = node.L.c;
                            node.L.c = null;

                        } else if (primerjava(e, node.L.b)) {
                            node.S.b = node.a;
                            if (primerjava(node.S.a, node.S.b)) {
                                node.S.b = node.S.a;
                                node.S.a = node.a;
                            }

                            node.a = e;

                        } else {
                            node.L.c = node.L.b;
                            node.L.b = e;

                            node.S.b = node.a;
                            if (primerjava(node.S.a, node.S.b)) {
                                node.S.b = node.S.a;
                                node.S.a = node.a;
                            }

                            node.a = node.L.c;
                            node.L.c = null;
                        }
                    } else {
                        if (primerjava(node.L.a, e)) {
                            if (node.D == null) {
                                node.D = new Element23();
                            }

                            node.D.a = node.S.a;
                            node.D.b = node.S.b;

                            node.S.a = node.L.b;
                            node.S.b = null;

                            node.b = node.a;
                            node.a = node.L.a;
                            node.L.a = e;
                            node.L.b = null;
                        } else if (primerjava(e, node.L.b)) {
                            if (node.D == null) {
                                node.D = new Element23();
                            }
                            node.D.a = node.S.a;
                            node.D.b = node.S.b;

                            node.S.a = e;
                            node.S.b = null;

                            node.b = node.a;
                            node.a = node.L.b;
                            node.L.b = null;
                        } else {
                            if (node.D == null) {
                                node.D = new Element23();
                            }
                            node.D.a = node.S.a;
                            node.D.b = node.S.b;

                            node.S.a = node.L.b;
                            node.S.b = null;

                            node.b = node.a;
                            node.a = e;
                            node.L.b = null;
                        }
                    }
                }
            } else {
                if (node.S.b == null) {
                    node.S.b = e;
                    if (primerjava(node.S.a, node.S.b)) {
                        node.S.b = node.S.a;
                        node.S.a = e;
                    } else {
                        node.S.b = e;
                    }
                } else { // če b ni null je treba mal premešat :(
                    if (velikost(node.L) != 2) {
                        if (primerjava(node.S.a, e)) {
                            node.L.b = node.a;
                            node.a = e;
                        } else if (primerjava(e, node.S.b)) {
                            node.L.b = node.a;
                            node.a = node.S.a;

                            node.S.a = node.S.b;
                            node.S.b = e;
                        } else {
                            node.L.b = node.a;
                            node.a = node.S.a;
                            node.S.a = e;

                        }
                    } else {
                        if (primerjava(node.S.a, e)) {
                            if (node.D == null) {
                                node.D = new Element23();
                            }
                            node.D.a = node.S.b;

                            node.b = node.S.a;

                            node.S.a = e;
                            node.S.b = null;
                        } else if (primerjava(e, node.S.b)) {
                            if (node.D == null) {
                                node.D = new Element23();
                            }
                            node.D.a = e;

                            node.b = node.S.b;

                            node.S.b = null;
                        } else {
                            if (node.D == null) {
                                node.D = new Element23();
                            }
                            node.D.a = node.S.b;

                            node.b = e;
                            node.S.b = null;
                        }
                    }

                }
            }
        } else if (velikost(node) == 2) {
            if (primerjava(node.a, e)) {
                if (velikost(node.L) != 2) {
                    node.L.b = e;
                    if (primerjava(node.L.a, node.L.b)) {
                        node.L.b = node.L.a;
                        node.L.a = e;
                    }
                } else if (velikost(node.S) != 2) {
                    if (primerjava(node.L.a, e)) {
                        node.L.c = node.L.b;
                        node.L.b = node.L.a;
                        node.L.a = e;

                        node.S.b = node.a;
                        if (primerjava(node.S.a, node.S.b)) {
                            node.S.b = node.S.a;
                            node.S.a = node.a;
                        }

                        node.a = node.L.c;
                        node.L.c = null;

                    } else if (primerjava(e, node.L.b)) {
                        node.S.b = node.a;
                        if (primerjava(node.S.a, node.S.b)) {
                            node.S.b = node.S.a;
                            node.S.a = node.a;
                        }

                        node.a = e;

                    } else {
                        node.L.c = node.L.b;
                        node.L.b = e;

                        node.S.b = node.a;
                        if (primerjava(node.S.a, node.S.b)) {
                            node.S.b = node.S.a;
                            node.S.a = node.a;
                        }

                        node.a = node.L.c;
                        node.L.c = null;
                    }
                } else {
                    

                    Tip najmanjsa = null;

                    if (primerjava(node.L.a, e)) {
                        najmanjsa = node.L.a;
                    } else if (primerjava(e, node.L.b)) {
                        najmanjsa = node.L.b;
                    } else {
                        najmanjsa = e;
                    }

                    Tip A = najmanjsa;
                    Tip B = node.a;
                    Tip C = node.b;

                    Element23 l = null;
                    Element23 s = null;
                    Element23 d = new Element23(node.S.a, node.S.b);
                    Element23 x = new Element23(node.D.a, node.D.b);

                    if (primerjava(node.L.a, e)) {
                        l = new Element23(e);
                        s = new Element23(node.L.b);
                    } else if (primerjava(e, node.L.b)) {
                        l = new Element23(node.L.a);
                        s = new Element23(e);
                    } else {
                        l = new Element23(node.L.a);
                        s = new Element23(node.L.b);
                    }

                    node.L.L = l;
                    node.L.S = s;
                    node.L.a = A;
                    node.L.b = null;

                    node.S.L = d;
                    node.S.S = x;
                    node.S.a = C;
                    node.S.b = null;

                    node.D = null;
                    node.a = B;
                    node.b = null;
                    pog = true;
                }
            } else if (primerjava(e, node.b)) {
                if (velikost(node.D) != 2) {
                    node.D.b = e;
                    if (primerjava(node.D.a, node.D.b)) {
                        node.D.b = node.D.a;
                        node.D.a = e;
                    }
                } else if (velikost(node.S) != 2) {
                    if (primerjava(node.D.a, e)) {
                        node.S.b = node.b;
                        node.b = e;
                    } else if (primerjava(e, node.D.b)) {
                        node.S.b = node.b;
                        node.b = node.D.a;
                        node.D.a = node.D.b;
                        node.D.b = e;
                    } else {
                        node.S.b = node.b;
                        node.b = node.D.a;
                        node.D.a = e;
                    }
                } else { // else še k so 3 v rootu
                    if (pog == true) {
                        vstavi = true;
                    }
                    Tip najmanjsa = null;

                    if (primerjava(node.D.a, e)) {
                        najmanjsa = node.D.a;
                    } else if (primerjava(e, node.D.b)) {
                        najmanjsa = node.D.b;
                    } else {
                        najmanjsa = e;
                    }

                    Tip A = node.a;
                    Tip B = node.b;
                    Tip C = najmanjsa;

                    Element23 l = new Element23(node.L.a, node.L.b);;
                    Element23 s = new Element23(node.S.a, node.S.b);
                    Element23 d = null;
                    Element23 x = null;

                    if (primerjava(node.D.a, e)) {
                        d = new Element23(e);
                        x = new Element23(node.D.b);
                    } else if (primerjava(e, node.D.b)) {
                        d = new Element23(node.D.a);
                        x = new Element23(e);
                    } else {
                        d = new Element23(node.D.a);
                        x = new Element23(node.D.b);
                    }

                    node.L.L = l;
                    node.L.S = s;
                    node.L.a = A;
                    node.L.b = null;

                    node.S.L = d;
                    node.S.S = x;
                    node.S.a = C;
                    node.S.b = null;

                    node.D = null;
                    node.a = B;
                    node.b = null;
                    pog = true;
                }
            } else {

                if (velikost(node.S) != 2) {
                    node.S.b = e;
                    if (primerjava(node.S.a, node.S.b)) {
                        node.S.b = node.S.a;
                        node.S.a = e;
                    }
                } else if (velikost(node.D) != 2) {
                    if (primerjava(node.S.a, e)) {
                        node.D.b = node.D.a;
                        node.D.a = node.b;

                        node.b = node.S.b;
                        node.S.b = node.S.a;
                        node.S.a = e;
                    } else if (primerjava(e, node.S.b)) {
                        node.D.b = node.D.a;
                        node.D.a = node.b;

                        node.b = e;
                    } else {
                        node.D.b = node.D.a;
                        node.D.a = node.b;

                        node.b = node.S.b;
                        node.S.b = e;
                    }
                } else if (velikost(node.L) != 2) {
                    if (primerjava(node.S.a, e)) {
                        
                        node.D.a = node.S.b;

                        node.b = node.S.a;

                        node.S.a = e;
                        node.S.b = null;
                    } else if (primerjava(e, node.S.b)) {
                        
                        node.D.a = e;

                        node.b = node.S.b;

                        node.S.b = null;
                    } else {
                        

                        node.L.b = node.S.a;

                        node.a = e;
                        node.S.a = node.S.b;
                        node.S.b = null;
                    }
                } else {
                    
                    Tip najmanjsa = null;

                    if (primerjava(node.S.a, e)) {
                        najmanjsa = node.S.a;
                    } else if (primerjava(e, node.S.b)) {
                        najmanjsa = node.S.b;
                    } else {
                        najmanjsa = e;
                    }

                    Tip A = node.a;
                    Tip B = najmanjsa;
                    Tip C = node.b;

                    Element23 l = new Element23(node.L.a, node.L.b);
                    Element23 s = null;
                    Element23 d = null;
                    Element23 x = new Element23(node.D.a, node.D.b);

                    if (primerjava(node.S.a, e)) {
                        s = new Element23(e);
                        d = new Element23(node.S.b);
                    } else if (primerjava(e, node.S.b)) {
                        s = new Element23(node.S.a);
                        d = new Element23(e);
                    } else {
                        s = new Element23(node.S.a);
                        d = new Element23(node.S.b);
                    }

                    node.L.L = l;
                    node.L.S = s;
                    node.L.a = A;
                    node.L.b = null;

                    node.S.L = d;
                    node.S.S = x;
                    node.S.a = C;
                    node.S.b = null;

                    node.D = null;
                    node.a = B;
                    node.b = null;
                    pog = true;
                }
            }
        }
        return (node);
    }

    public int velikost(Element23 poglej) {
        int st = 0;
        if (poglej.a != null) {
            st++;
        }
        if (poglej.b != null) {
            st++;
        }
        return st;
    }

    public Element23 posebenInsert(Tip e, Element23 node) {
        if (globina(node) != 2) {
            if (primerjava(node.a, e)) {
                posebenInsert(e, node.L);
            } else if (node.b != null && primerjava(e, node.b)) {
                posebenInsert(e, node.D);
            } else {
                posebenInsert(e, node.S);
            }
        } else {
            node = insert(e, node);
            zac = node;
        }
        return (node);
    }

    @Override
    public void add(Tip e) {
        if (obstaja(e, rootNode)) {
            throw new UnsupportedOperationException();
        }
        if (pog == true) {
            rootNode = posebenInsert(e, rootNode);
            if (vstavi == true) {
                if (primerjava(zac.a, rootNode.a)) {
                    rootNode.b = zac.a;
                    rootNode.S = zac.L;
                    rootNode.D = zac.S;
                }
                zac = null;
                vstavi = false;
            }
        } else {
            rootNode = insert(e, rootNode);
        }

        n++;
    }

    @Override
    public Tip removeFirst() {
        if(rootNode == null){
            return null;
        }else{
            Tip zac = rootNode.a;
            odstrani(zac, rootNode);
            return(zac);
        }
    }

    @Override
    public Tip getFirst() {
        return rootNode.a;
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public int depth() {
        if (rootNode == null) {
            return 0;
        } else {
            return dp(rootNode);
        }
    }

    public int dp(Element23 node) {
        if (node.L == null) {
            return 1;
        } else {
            return 1 + dp(node.L);
        }
    }

    public int globina(Element23 node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + globina(node.L);
        }
    }

    @Override
    public boolean isEmpty() {
        if (rootNode == null) {
            return true;
        } else {
            return false;
        }
    }

    public Tip odstrani(Tip e, Element23 node) {
        if (globina(node) == 1) { // če mamo max 2 not
            if (node.a.equals(e)) {
                if (node.b != null) {
                    node.a = node.b;
                    node.b = null;

                    n--;
                    return (e);
                }else{
                    node.a = null;
                    n--;
                    return(e);
                }
            } else {
                node.b = null;
                n--;
                return (e);
            }
        } else if (globina(node) == 2 && node.b != null) { // če mamo že otroke
            if (node.L.a.equals(e)) {
                if (node.L.b != null) {
                    node.L.a = node.L.b;
                    node.L.b = null;
                    n--;
                    return (e);
                } else {
                    if (node.S.b == null) {
                        Tip zac = node.a;
                        node.L = node.S;
                        node.S = node.D;
                        node.D = null;
                        node.L.b = node.L.a;
                        node.L.a = zac;

                        node.a = node.b;
                        node.b = null;
                        n--;
                        return (e);
                    } else {
                        node.L.a = node.a;
                        node.a = node.S.a;
                        node.S.a = node.S.b;
                        node.S.b = null;
                        n--;
                        return (e);
                    }

                }
            } else if (node.L.b != null && node.L.b.equals(e)) {
                node.L.b = null;
                n--;
                return (e);
            } else if (node.S.a.equals(e)) {
                if (node.S.b != null) {
                    node.S.a = node.S.b;
                    node.S.b = null;
                    n--;
                    return (e);
                } else {
                    if (node.D.b == null) {
                        node.D.b = node.D.a;
                        node.D.a = node.b;
                        node.S = node.D;
                        node.D = null;
                        node.b = null;
                        n--;
                        return (e);
                    } else if (node.L.b == null) {
                        node.L.b = node.a;
                        node.a = node.b;
                        node.b = null;
                        node.S = node.D;
                        node.D = null;
                        n--;
                        return (e);
                    } else {
                        node.S.a = node.a;
                        node.a = node.L.b;
                        node.L.b = null;
                        n--;
                        return (e);
                    }
                }
            } else if (node.S.b != null && node.S.b.equals(e)) {
                node.S.b = null;
                n--;
                return (e);
            } else if (node.D != null && node.D.a.equals(e)) {
                    if(node.D.b != null){
                        node.D.a = node.D.b;
                        node.D.b = null;
                        n--;
                        return(e);
                    }else{
                        if(node.S.b != null){
                            node.D.a =node.b;
                            node.b = node.S.b;
                            node.S.b = null;
                            n--;
                            return(e);
                        }else{
                            node.S.b = node.b;
                            node.b = null;
                            node.D = null;
                            n--;
                            return(e);
                        }
                    }      
            }else if(node.D.b != null && node.D.b.equals(e)){
                node.D.b = null;
                n--;
                    return(e);
            }else if(node.a.equals(e)){
                if(node.L.b == null && node.S.b != null){
                    node.a = node.S.a;
                    node.S.a = null;
                    node.S.a = node.S.b;
                    node.S.b = null;
                    n--;
                    return(e);
                }else if(node.L.b != null){
                    node.a = node.L.b;
                    node.L.b = null;
                    n--;
                    return(e);
                }
            }else{
                if(node.S.b == null && node.D.b != null){
                    node.b = node.D.a;
                    node.D.a = node.D.b;
                    node.D.b = null;
                    n--;
                    return(e);
                }
            }
        } else if (globina(node) == 2 && node.b == null) {
            if (node.L.a.equals(e)) {
                if (node.L.b != null) {
                    node.L.a = node.L.b;
                    node.L.b = null;
                    n--;
                    return (e);
                } else {
                    if (node.S.b == null) {
                        node.b = node.S.a;
                        node.S = null;
                        node.L = null;
                        n--;
                        return (e);
                    } else {
                        node.L.a = node.a;
                        node.a = node.S.a;
                        node.S.a = node.S.b;
                        node.S.b = null;
                        n--;
                        return (e);
                    }
                }
            } else if (node.L.b != null && node.L.b.equals(e)) {
                node.L.b = null;
                n--;
                return (e);
            } else if (node.S.a.equals(e)) {
                if (node.S.b != null) {
                    node.S.a = node.S.b;
                    node.S.b = null;
                    n--;
                    return (e);
                } else {
                    if (node.L.b == null) {
                        node.b = node.a;
                        node.a = node.L.a;
                        node.L = null;
                        node.S = null;
                        n--;
                        return (e);
                    } else {
                        node.S.a = node.a;
                        node.a = node.L.b;
                        node.L.b = null;
                        n--;
                        return (e);
                    }
                }
            } else if (node.a.equals(e)) {
                if (node.L.b == null && node.S.b == null) {
                    node.a = node.L.a;
                    node.b = node.S.a;
                    node.L = null;
                    node.S = null;
                    n--;
                    return (e);
                } else if (node.L.b != null && node.S.b != null) {
                    node.a = node.S.a;
                    node.S.a = node.S.b;
                    node.S.b = null;
                    n--;
                    return (e);
                } else if (node.L.b != null && node.S.b == null) {
                    node.a = node.L.b;
                    node.L.b = null;
                    n--;
                    return (e);
                } else {
                    node.a = node.S.a;
                    node.S.a = node.S.b;
                    node.S.b = null;
                    n--;
                    return (e);
                }
            }
        }
        return null;
    }

    @Override
    public Tip remove(Tip e) {
        if (rootNode.a == null || !obstaja(e, rootNode)) {
            return null;
        } else {
            return (odstrani(e, rootNode));
        }
    }

    public boolean obstaja(Tip e, Element23 node) {
        if (node == null || node.a == null) {
            return false;
        } else if (node.a == e) {
            return true;
        } else if (node.b == e) {
            return true;
        } else {
            if (primerjava(node.a, e)) {
                return obstaja(e, node.L);
            } else if (node.b != null && primerjava(e, node.b)) {
                return obstaja(e, node.D);
            } else {
                return obstaja(e, node.S);
            }
        }
    }

    @Override
    public boolean exists(Tip e) {
        if (rootNode == null) {
            return false;
        } else {
            return (obstaja(e, rootNode));
        }

    }
    
    
 

    List<Tip> vrni = new ArrayList<Tip>();

    @Override
    public List asList() {
        vrni = new ArrayList<Tip>();
        if (rootNode == null) {
            return null;
        } else {
            preorder(rootNode);
        }
        return vrni;
    }

    public void preorder(Element23 node) {
        if (node == null) {
            return;
        }

        if (node.b != null) {
            vrni.add(node.a);
            vrni.add(node.b);
        } else {
            vrni.add(node.a);
        }

        preorder(node.L);

        preorder(node.S);
        if (node.b != null) {
            preorder(node.D);
        }

    }

}
