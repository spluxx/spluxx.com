import shutil
import urllib.request

with open('image_urls.txt', 'r') as urls:
    idx = 1
    for url in urls:
        print(idx)
        req = urllib.request.Request(url.strip(), headers={'User-Agent': 'Mozilla/5.0'}) 
        with urllib.request.urlopen(req) as response, open('./'+str(idx)+'.png', 'wb') as out_file:
            shutil.copyfileobj(response, out_file)
        idx = idx + 1
