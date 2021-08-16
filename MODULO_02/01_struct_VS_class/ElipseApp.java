public class ElipseApp {
    public static void main (String[] args) 
    {
         Elipse elipse1 = new Elipse(5, 1, 40, 40, 50, 70);
         elipse1.print();    
    }
}

class Elipse{
    int cor_de_fundo;
    int tamanho_da_borda;
    int Rx, Ry;
    int x, y;

    Elipse(int cor, int t_borda, int Rx, int Ry, int x, int y)
    {
        this.cor_de_fundo = cor;
        this.tamanho_da_borda = t_borda;
        this.Rx = Rx;
        this.Ry = Ry;
        this.x = x;
        this.y = y;

    }

    void print()
    {
        System.out.format("Propriedades de um objeto do tipo Elipse:\n");
        System.out.format("cor de de fundo: %d\n", this.cor_de_fundo);
        System.out.format("tamanho da borda: %d\n", this.tamanho_da_borda);
        System.out.format("Raios: (%d,%d)\n", this.Rx, this.Ry);
        System.out.format("Posicao: (%d,%d)\n", x, y);
    }
}