
class Cidade:
    def __init__(self,nome, temperatura, escala, numero):
        self.nome = nome
        self.temperatura = temperatura
        self.escala = escala
        self.numero = numero
    def media(self):
        if self.escala == 'C':
            self.temperatura = (self.temperatura * (9/5)) + 32
            self.escala = 'F'
        self.temperatura = float("{:.4}".format(self.temperatura/self.numero))


cidades = []


file = open("citytemp.csv", "r")
new_file = open("cityaverage.csv", "w")
file.seek(0)

for iteracao in file:

    temp = iteracao.rstrip('\n')
    dados = temp.split(',')
    cidade = Cidade(dados[0], float(dados[1]), dados[2], 1)
    tester = False

    for itera in cidades:

        if itera.nome == dados[0]:
            itera.temperatura+=float(dados[1])
            itera.numero+=1
            tester = True
    if not tester:

        cidades.append(cidade)



for cidade in cidades:

    cidade.media()
    new_file.write(cidade.nome + ',' + str(cidade.temperatura) + ',' + cidade.escala + "," + str(cidade.numero) + '\n')

new_file.close()
file.close()
