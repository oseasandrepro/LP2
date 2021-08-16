#include <stdio.h>

enum Fonte_ { Fonte_Impact, Fonte_Arial, Fonte_ArialBlack, Fonte_Webdings };


typedef struct{
    enum Fonte_ fonte;
    int tamanho;
    float espa_letras;
    int x,y;
    char* caracteres;
}TEXTO;

void print(TEXTO *T);


int main(void)
{
    TEXTO texto1 = {Fonte_Arial, 12, 0.5, 30, 30, "Hello Word!"};

    print(&texto1);

    return 0;
}

void print(TEXTO* T)
{
    printf("Propriedades de um \'objeto\' do tipo TEXTO:\n");
    printf("fonte: %d\n", T->fonte);
    printf("tamanho da fonte: %d\n", T->tamanho);
    printf("espaçamento entre as letras: %.2f\n", T->espa_letras);
    printf("posicao: (%d, %d)\n", T->x, T->y);
    printf("Caracteres:%s\n", T->caracteres);
    printf("\n");
}