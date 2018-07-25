from bs4 import BeautifulSoup
import requests
import shutil
import csv

nameList = []
with open('pokemon.csv', 'r') as pokedata:
    reader = csv.DictReader(pokedata, delimiter=',', quotechar='"')
    for row in reader:
        prefix = row['id'] 
        prefix = '0'*(3-len(prefix))+prefix
        suffix = row['identifier'].title()
        nameList.append(prefix+suffix)

urlList = []
for idx in range(444, 722):
    url = 'https://bulbapedia.bulbagarden.net/wiki/File:'+nameList[idx-1]+'.png'
    f = requests.get(url)
    soup = BeautifulSoup(f.text, "html.parser")
    try:
        div = soup.findAll("div", {"class": "fullImageLink"})[0]
        url = 'http:'+div.a.get('href')
        urlList.append(url)
    except: 
        print('failure!: '+str(idx))
    print(url)
