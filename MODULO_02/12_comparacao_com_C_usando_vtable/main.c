#include <stdio.h>
#include <stdlib.h>
#include <math.h>

enum Color {BLACK, WHITE, ORANGE, GREEN, BLUE, YELLOW, RED};
typedef enum Color Color;
void TheColor(Color co){
	switch(co){
	case BLACK:	printf("BLACK");	break;
	case WHITE:	printf("WHITE");	break;
	case ORANGE:	printf("ORANGE");	break;
	case GREEN:	printf("GREEN");	break;
	case BLUE:	printf("BLUE");		break;
	case YELLOW:	printf("YELLOW");	break;
	case RED:	printf("RED");		break;
	}
}

struct Figure;
typedef void (* FigurePrint) (struct Figure*);
typedef int  (* FigureArea)  (struct Figure*);
typedef void (* FigureRotation) (struct Figure*); 

typedef struct {
    void (* print)	(struct Figure*);
    int  (* area)	(struct Figure*);
    void (* rotation)	(struct Figure*); //rotação da figura em 90 graus positivos(para esquerda)
} Figure_vtable;

typedef struct Figure{
	int x,y;
	int w,h;
	Color BorderColor;
    	Color BckgColor;
    	Figure_vtable* vtable;
}Figure;

///////////////////////////////////////////////////////

typedef struct{
	Figure super;
}Rect;

void PrintRect(Rect *this){
	Figure* sup = (Figure*) this;
	printf("Retangulo -----------------------\n");
	printf("Posicao:(%d, %d)\nTamanho (%d, %d)\n", sup->x, sup->y, sup->w, sup->h);
	printf("area %d\n", sup->vtable->area(sup));
	printf("Cor de contorno: "); TheColor(sup->BorderColor); printf("\n");
	printf("Cor de fundo: "); TheColor(sup->BckgColor); printf("\n");
	printf("--------------------------------\n\n");
}
int AreaRect(Rect *this){
	Figure* sup = (Figure*) this;
	return (sup->w * sup->h);
}
void RotationRect(Rect *this){
	Figure* sup = (Figure*) this;
	int aux;
	
	//Rotacionando o ponto (x,y) do canto superior esquerdo do retangulo
	aux = sup->x;
	sup->x = -sup->y;
	sup->y = aux;
	
	aux = sup->w;
	sup->w = sup->h;
	sup->h = aux;
}

Figure_vtable RectVtable = {	(FigurePrint) PrintRect, (FigureArea) AreaRect, 
				(FigureRotation) RotationRect};

Rect* NewRect(int x, int y, int w, int h, Color bordercolor, Color bckgcolor)
{
	Rect*   this = (Rect*)malloc(sizeof(Rect));
    	Figure* sup = (Figure*) this;
    	sup->vtable = &RectVtable;
    	sup->x = x;
    	sup->y = y;
    	sup->w = w;
    	sup->h = h;
    	sup->BorderColor = bordercolor;
    	sup->BckgColor = bckgcolor;
    	
    	return this;
}



//////////////////////////////////////////////////////

typedef struct{
	Figure super;
	int x1,y1;
	int x2,y2;
}Triangle;
void PrintTriangle(Triangle* this)
{
	Figure* sup = (Figure*) this;
	printf("------------------- Triangulo -------------------------\n");
	printf("Posicao dos pontos :(%d, %d), (%d, %d), (%d, %d)\n",	sup->x, sup->y, this->x1,
									this->y1, this->x2, this->y2);
	printf("Tamanho dos lados: %d\n", sup->w);
	printf("area %d\n", sup->vtable->area(sup));
	printf("Cor de contorno: "); TheColor(sup->BorderColor); printf("\n");
	printf("Cor de fundo: "); TheColor(sup->BckgColor); printf("\n");
	printf("--------------------------------------------------------\n\n");
	
	
}

int AreaTriangle(Triangle *this){
	Figure* sup = (Figure*) this;
	return (int)(((sup->w*sup->w)*sqrt(3))/4.0);
}

void RotationTriangle(Triangle *this){
	Figure* sup = (Figure*) this;
	int aux;
	//Rotacionando os três pontos do triangulo
	aux = sup->x;
	sup->x = -sup->y;
	sup->y = aux;
	
	aux = this->x1;
	this->x1 = -this->y1;
	this->y1 = aux;
	
	aux = this->x2;
	this->x2 = -this->y2;
	this->y2 = aux;
}


Figure_vtable TriangleVtable = {	(FigurePrint) PrintTriangle, (FigureArea) AreaTriangle, 
					(FigureRotation) RotationTriangle };

Triangle* NewTriangle(int x, int y, int w, int h, Color bordercolor, Color bckgcolor)
{
	Triangle*   this = (Triangle*)malloc(sizeof(Triangle));
    	Figure* sup = (Figure*) this;
    	sup->vtable = &TriangleVtable;
    	sup->x = x;
    	sup->y = y;
    	this->x1 = x-w;
    	this->y1 = y+w;
    	this->x2 = x+w;
    	this->y2 = y+w;
    	sup->w = w;
    	sup->h = h;
    	sup->BorderColor = bordercolor;
    	sup->BckgColor = bckgcolor;
    	
    	return this;
}
int main(void)
{
	 Figure* figs[4] = {
        (Figure*) NewRect(5, 3, 50,50, BLACK, YELLOW),
        (Figure*) NewRect(56, 54, 50, 50, BLACK, BLUE),
        (Figure*) NewTriangle(150,150, 80,80, GREEN, BLACK),
        (Figure*) NewTriangle(200,100, 40,40, ORANGE, RED)
    	};

    ///

    for (int i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
    }
    
    //Rotacionar o primeiro triangulo
    printf("Rotacionar o primeiro triangulo\n");
    figs[2]->vtable->rotation(figs[2]);
    figs[2]->vtable->print(figs[2]);

    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
	return 0;
}
