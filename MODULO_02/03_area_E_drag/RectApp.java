public class RectApp{
    public static void main(String args[])
    {
        int a,b;
        Rect r1 = new Rect(20, 30, 100, 50);
        r1.print();
        System.out.format("Area do Rectangulo: %d\n", r1.area());

        a = 30; b = 20;
        r1.drag(a, b);
        System.out.format("mover %d unidades em x e %d unidades em y\n", a, b);
        r1.print();

    }
}

class Rect 
{
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void print () 
    {
      System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
          this.w, this.h, this.x, this.y);
    }

    int area(){
            return (this.w * this.h);
    } 

    void drag(int dx, int dy){
        this.x = this.x + dx;
        this.y = this.y + dy;
    }
}