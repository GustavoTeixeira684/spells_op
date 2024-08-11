

if __name__ == "__main__":

    with open("input.txt", 'r', encoding='utf-8') as file:
        text = file.readlines()

    output = open("output.json",'w',encoding='utf-8')
    output.write("[\n")
    
    text = [x.replace('\n','') for x in text if x != '\n']

    contador_id = 0

    i = 0
    titulo,descricao,energia,duracao,alcance,requisito,dano,grau = "","","","","","","",""
    while i < len(text):
        descricao = ""
        grau = text[i][0]
        i += 2
        titulo = text[i]
        i+=1
        while not text[i].isdigit():
            descricao += text[i].replace('\n',' ')
            i+=1
        descricao = descricao.strip()
        energia = int(text[i].replace('\n',''))
        i+=1
        while("Duração" not in text[i]):
            i+=1
        duracao = text[i].replace("Duração ",'')
        i+=1
        alcance = text[i].replace("Alcance ",'')
        i+=1
        requisito = text[i].replace("Requisito ",'')
        i+=1
        dano = text[i].replace("Dano ",'')
        i+=2
        print("titulo",titulo)
        print("descricao",descricao)
        print("energia",energia)
        print("duracao",duracao)
        print("alcance",alcance)
        print("requisito",requisito)
        print("dano",dano)
        print("grau",grau)
        print()
        output.write("\t{\n")
        output.write('\t\t"id":'+str(contador_id)+',\n')
        output.write('\t\t"titulo":'+'"'+titulo+'",\n')
        output.write('\t\t"descricao":'+'"'+descricao+'",\n')
        output.write('\t\t"energia":'+'"'+str(energia)+'",\n')
        output.write('\t\t"duracao":'+'"'+duracao+'",\n')
        output.write('\t\t"alcance":'+'"'+alcance+'",\n')
        output.write('\t\t"requisito":'+'"'+requisito+'",\n')
        output.write('\t\t"dano":'+'"'+dano+'",\n')
        output.write('\t\t"grau":'+'"'+grau+'"\n')
        output.write("\t}")
        if i < len(text):
            output.write(",\n")
        else:
            output.write("\n")


        contador_id += 1
    output.write("]")
    output.flush()
    output.close()




    

