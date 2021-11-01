#include "rect.h"
#include <stdio.h>
#include <stdlib.h>

struct Rect{
	int x,y;
	int w,h;
};

Rect* rect_new(void)
{
	Rect* newRect = (Rect*)malloc(sizeof(Rect));
	newRect->x = 0;
	newRect->y = 0;
	newRect->w = newRect->h = 20;
	
	return newRect;
}
void rect_drag(Rect* this, int dx, int dy)
{
	this->x = this->x + dx;
	this->y = this->y + dy;
}
void rect_print(Rect* this){
	printf("(%d, %d) (%d, %d)\n", this->x, this->y, this->w, this->h);
}
