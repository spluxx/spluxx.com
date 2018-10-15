import csv
import json

flavor_texts = {}
with open('flavor_text.csv', 'r') as flavor_text:
    reader = csv.DictReader(flavor_text, delimiter=',', quotechar='"')

    idx = 1
    tmp = set()
    for row in reader:
        i = int(row['species_id'])
        if i > idx:
            flavor_texts[idx] = list(tmp)
            idx = i
            tmp = set()

        if row['language_id'] == '9': # english
            tmp.add(row['flavor_text'])
    flavor_texts[idx] = list(tmp)
     
res = []
with open('pokemon.csv', 'r') as pokedata:
    reader = csv.DictReader(pokedata, delimiter=',', quotechar='"')
    for row in reader:
        idx = row['id']
        res.append({
            'id': idx,
            'name': row['identifier'],
            'weight': str(float(row['weight'])/10),
            'height': str(float(row['height'])/10),
            'description': flavor_texts[int(idx)],
            'img_url': "http://spluxx.com/api/images/"+idx+".png",
            'cry_url': "http://spluxx.com/api/cries/"+idx+".mp3"
        })

print(json.dumps(res, indent=4, separators=(',', ': ')))
