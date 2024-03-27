#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct cidades{
    int ID,num_conexoes;
    int *conexao;
    char nome[50];

}CIDADES;

typedef struct cdds{

    CIDADES *cidades;

    int     *matrix,
            *num_cdds;

}CITY_MATRIX;
void innit_cityMatrix(CITY_MATRIX *matrix);
void add_cidade(CITY_MATRIX *matrix, char *nome);
void save(CITY_MATRIX *matrix);
void load(CITY_MATRIX *matrix);
void menu(CITY_MATRIX *matrix);
void print_lista_cidades(CITY_MATRIX *matrix);
void add_conexao(CITY_MATRIX *matrix);
int check_conexao(int *conexoes, int* alvo, int *num_conexoes);
int dado_matrix(CITY_MATRIX *matrix, int *l, int *c);



// Function to print the CITY_MATRIX data
void print_city_matrix(const CITY_MATRIX *matrix) {
  printf("CITY_MATRIX (%p):\n", matrix);  // Print address of CITY_MATRIX

  if (matrix == NULL) {
    printf("  (null)\n");
    return;  // Early exit if matrix is NULL
  }

  printf("  num_cdds (%p): %d\n", matrix->num_cdds, *(matrix->num_cdds));  // Print address and value of num_cdds

  if (matrix->cidades == NULL) {
    printf("  cidades: (null)\n");
    return;  // Early exit if cidades is NULL
  }

  printf("  cidades (%p):\n", matrix->cidades);  // Print address of cidades array

  for (int i = 0; i < *(matrix->num_cdds); i++) {
    printf("    Cidade %d (%p):\n", i, &matrix->cidades[i]);  // Print address of each city in cidades

    printf("      ID: %d\n", matrix->cidades[i].ID);
    printf("      nome: %s\n", matrix->cidades[i].nome);
    printf("      num_conexoes: %d\n", matrix->cidades[i].num_conexoes);

    if (matrix->cidades[i].conexao == NULL) {
      printf("      conexao: (null)\n");
    } else {
      printf("      conexao (%p):\n", matrix->cidades[i].conexao);  // Print address of conexao array if not NULL
    }
  }

  if (matrix->matrix != NULL) {
    printf("  matrix (%p): (implementation not shown)\n", matrix->matrix);  // Placeholder for matrix (if applicable)
  }
}

// Function to print the CITY_MATRIX data
void print_city_matrix1( CITY_MATRIX *matrix) {
  printf("CITY_MATRIX (%p):\n", matrix);  // Print address of CITY_MATRIX

  if (matrix == NULL) {
    printf("  (null)\n");
    return;  // Early exit if matrix is NULL
  }

  printf("  num_cdds (%p): %d\n", matrix->num_cdds, *(matrix->num_cdds));  // Print address and value of num_cdds

  if (matrix->cidades == NULL) {
    printf("  cidades: (null)\n");
    return;  // Early exit if cidades is NULL
  }

  printf("  cidades (%p):\n", matrix->cidades);  // Print address of cidades array

  for (int i = 0; i < *(matrix->num_cdds); i++) {
    printf("    Cidade %d (%p):\n", i, &matrix->cidades[i]);  // Print address of each city in cidades

    printf("      ID: %d\n", matrix->cidades[i].ID);
    printf("      nome: %s\n", matrix->cidades[i].nome);
    printf("      num_conexoes: %d\n", matrix->cidades[i].num_conexoes);

    if (matrix->cidades[i].conexao == NULL) {
      printf("      conexao: (null)\n");
    } else {
      printf("      conexao (%p):\n\nConexoes: [", matrix->cidades[i].conexao);  // Print address of conexao array if not NULL
      for(int l=0;l<matrix->cidades[i].num_conexoes;l++){

        printf(" %d ",matrix->cidades[i].conexao[l]);

      }
      printf("]\n\n");

    }
  }

  if (matrix->matrix != NULL) {
    printf("\n\nMatrix de conexoes entre cidades:\n\n");
    for(int l = 0; l<(*matrix->num_cdds);l++){

        for(int c = 0;c<(*matrix->num_cdds);c++){
            printf("%d", matrix->matrix[l*(*matrix->num_cdds)+c]);
            //matrix->matrix[l*(*matrix->num_cdds)+c]==1?printf("1"):printf("0");  // Placeholder for matrix (if applicable)
        }
        printf("\n");
    }
  }
}

int main()

{

    CITY_MATRIX *matrix = (CITY_MATRIX*)malloc(sizeof(CITY_MATRIX));
    innit_cityMatrix(matrix);
    /*
    matrix?printf("\nCERTO\n"):printf("\nERRO\n");
    matrix->matrix?printf("\nCERTO\n"):printf("\nERRO\n");
    matrix->num_cdds?printf("\nCERTO\n"):printf("\nERRO\n");
    matrix->cidades?printf("\nCERTO\n"):printf("\nERRO\n");
*/
    menu(matrix);
    //save(matrix);
    free(matrix);







    return 0;
}

void innit_cityMatrix(CITY_MATRIX *matrix){

    matrix->cidades  = (CIDADES*)malloc(sizeof(CIDADES)+1);
    matrix->num_cdds = (int*)calloc(1,sizeof(int));
    matrix->matrix   = (int*)malloc(sizeof(int));
}
int check_conexao(int *conexoes, int *alvo, int *num_conexoes){
    for(int i=0;i<*num_conexoes;i++){
        if(*alvo==conexoes[i]){
            return 1;
        }
    }
    return 0;
}
void add_cidade(CITY_MATRIX *matrix, char *nome){

    strcpy(matrix->cidades[*(matrix->num_cdds)].nome,nome);

    matrix->cidades[*(matrix->num_cdds)].ID           = (*(matrix->num_cdds));
    matrix->cidades[*(matrix->num_cdds)].num_conexoes = 0;
    matrix->cidades[(*(matrix->num_cdds))++].conexao  = (int*)malloc(sizeof(int));

    matrix->cidades = (CIDADES*)realloc(matrix->cidades,sizeof(CIDADES)*((*(matrix->num_cdds))+1));
    matrix->matrix  = (int*)realloc(matrix->matrix,sizeof(int)*(*(matrix->num_cdds)*(*(matrix->num_cdds))));
    for(int l=0;l<(*matrix->num_cdds);l++){

        for(int c=0; c<(*matrix->num_cdds); c++){
            matrix->matrix[l*(*matrix->num_cdds)+c] = check_conexao(matrix->cidades[l].conexao, &c, &matrix->cidades[l].num_conexoes);
        }

    }

}

void add_conexao(CITY_MATRIX *matrix){
    int cidade, resp, resp2;

    if((*matrix->num_cdds)==0){
        printf("\n\n[Lista vazia]\n\n");
        return;
    }
    print_lista_cidades(matrix);
    printf("\nDigite o ID da cidade para qual voce deseja adicionar uma conecao: \n");

    scanf("%d", &cidade);
    if(cidade<0 || cidade>=(*(matrix->num_cdds))){
        return;
    }

    for(;;){
        print_lista_cidades(matrix);
        printf("\nDigite o ID da cidade para qual vc deseja conectar a %s ou digite 666 para sair\n", matrix->cidades[cidade].nome);
        scanf("%d",&resp);
        if(0>resp || resp>=(*(matrix->num_cdds))){
            return;
        }

        if(!check_conexao(matrix->cidades[cidade].conexao, &resp, &matrix->cidades[cidade].num_conexoes)){

            matrix->cidades[cidade].conexao[matrix->cidades[cidade].num_conexoes] = resp;
            matrix->matrix[cidade*(*matrix->num_cdds)+resp]=1;

            printf("\nEssa conexao e multua(permite ir e vir)?\n1 - sim\n0 - nao\n\n");
            scanf("%d", &resp);
            if(resp==1 && !check_conexao(matrix->cidades[resp].conexao, &cidade, &matrix->cidades[resp].num_conexoes)){
                matrix->cidades[matrix->cidades[cidade].conexao[matrix->cidades[cidade].num_conexoes]].conexao[matrix->cidades[matrix->cidades[cidade].conexao[matrix->cidades[cidade].num_conexoes]].num_conexoes++] = cidade;
                matrix->matrix[matrix->cidades[cidade].conexao[matrix->cidades[cidade].num_conexoes]*(*matrix->num_cdds)+cidade]=1;
                matrix->cidades[matrix->cidades[cidade].conexao[matrix->cidades[cidade].num_conexoes]].conexao = (int*)realloc(matrix->cidades[matrix->cidades[cidade].conexao[matrix->cidades[cidade].num_conexoes]].conexao, sizeof(int)*(1+(matrix->cidades[matrix->cidades[cidade].conexao[matrix->cidades[cidade].num_conexoes]].num_conexoes)));

            }
            matrix->cidades[cidade].conexao = (int*)realloc(matrix->cidades[cidade].conexao,sizeof(int)*((matrix->cidades[cidade].num_conexoes++)+1));

        }else{
            if(check_conexao(matrix->cidades[resp].conexao, &cidade, &matrix->cidades[resp].num_conexoes)){
                    printf("\nEssa conexao ja existe e eh multua\n");
                    return;
            }

            printf("\nEssa conexao ja existe, quer q seja multua(permite ir e vir)?\n1 - sim\n0 - nao\n\n");
            scanf("%d", &resp2);
            if(resp2==1){
                matrix->cidades[resp].conexao[matrix->cidades[resp].num_conexoes++]=cidade;
                matrix->matrix[resp*(*matrix->num_cdds)+cidade]=1;
                matrix->cidades[resp].conexao=(int*)realloc(matrix->cidades[resp].conexao, sizeof(int)*(1+(matrix->cidades[resp].num_conexoes)));

            }

        }






    }


}/*
int dado_matrix(CITY_MATRIX *matrix){

    for(int i=0;i<(*(matrix->num_cdds))*(*(matrix->num_cdds));i++){

    }
}*/

void save(CITY_MATRIX *matrix){

    FILE   *fp;
    fp    = fopen("mapa.txt","w");

    fprintf(fp,"%d\n",*matrix->num_cdds);

    for(int i = 0;i<(*(matrix->num_cdds));i++){

        fprintf(fp,"%s\n%d\n%d\n",matrix->cidades[i].nome,matrix->cidades[i].ID, matrix->cidades[i].num_conexoes);

        for(int j=0;j<(matrix->cidades[i].num_conexoes);j++){

            fprintf(fp,"%d\n",matrix->cidades[i].conexao[j]);
        }
    }
    for(int i=0;i<(*matrix->num_cdds)*(*matrix->num_cdds);i++){

        fprintf(fp,"%d", matrix->matrix[i]);

    }
    fprintf(fp,"%c",EOF);
    fclose(fp);

}

void load(CITY_MATRIX *matrix){
    FILE *fp;
    matrix = NULL;
    matrix = (CITY_MATRIX*)malloc(sizeof(CITY_MATRIX));
    innit_cityMatrix(matrix);
    char buffer;
    fp = fopen("mapa.txt","r");

    fscanf(fp,"%d",matrix->num_cdds);

    matrix->cidades = (CIDADES*)realloc(matrix->cidades,sizeof(CIDADES)*(1+(*(matrix->num_cdds)))); ///+1
    matrix->matrix  = (int*)realloc(matrix->matrix,sizeof(CIDADES)*(*(matrix->num_cdds))*(*(matrix->num_cdds)));
    buffer = fgetc(fp);

    for(int i=0;i<(*(matrix->num_cdds));i++){

        fscanf(fp,"%[^\n]",matrix->cidades[i].nome);
        buffer = fgetc(fp);
        fscanf(fp,"%d",&matrix->cidades[i].ID);
        buffer = fgetc(fp);
        fscanf(fp,"%d",&matrix->cidades[i].num_conexoes);
        buffer = fgetc(fp);

        matrix->cidades[i].conexao=(int*)malloc(sizeof(int)*(1+matrix->cidades[i].num_conexoes));

        for(int j=0;j<(matrix->cidades[i].num_conexoes);j++){

            fscanf(fp,"%d",&matrix->cidades[i].conexao[j]);
            buffer = fgetc(fp);
        }
    }
    printf("ok");

    for(int i=0;i<(*matrix->num_cdds)*(*matrix->num_cdds);i++){

        fscanf(fp,"%d", matrix->matrix[i]);

    }
    fclose(fp);
}

void menu(CITY_MATRIX *matrix){
    int op;
    char *cidade=(char*)malloc(sizeof(char)*50);
    printf("Selecione uma opcao\n\n");
    printf("1 - Adicionar cidade\n2 - Salvar\n3 - Carregar grafo\n4 - voltar ao menu\n5 - Imprimir lista de cidades\n6 - Fazer conexao\n\n");
    scanf("%d", &op);
    printf("\n---------\n");
    print_city_matrix1(matrix);
    printf("\n---------\n");
    switch(op){
    case 1:

        //system("cls");
        printf("Digite o nome da cidade:\n\n");
        fflush(stdin);
        scanf("%[^\n]", cidade);
        add_cidade(matrix,cidade);
        free(cidade);
        menu(matrix);
    case 2:
        save(matrix);
        menu(matrix);
    case 3:
        load(matrix);
        menu(matrix);
    case 4:
        menu(matrix);
    case 5:
        print_lista_cidades(matrix);
        menu(matrix);
    case 6:
        add_conexao(matrix);
        menu(matrix);
    }

}
void print_lista_cidades(CITY_MATRIX *matrix){

    for(int i=0;i<(*matrix->num_cdds);i++){
            printf("ID: %d  Nome: %s\n", matrix->cidades[i].ID, matrix->cidades[i].nome);

    }

}
