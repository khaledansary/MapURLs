# MapURLs
#Mapping short and expanded URLs


The program read the file which contains mapped short->expanded URLs seperated by tab

it create first map called url_map which contains 
as key = short_url  and values = list of expanded_urls which under this short_url

for example,

http://amzn.to/Zs	http://www.amazon.com\n
http://cl.ly/Z7Ej	http://wiki.blender.org/index.php/Dev:Ref/Release_Notes/2.73/More_Features
http://bit.ly/n231	http://www.rcrwireless.com/article/20140521/infrastructure-2/pcia-2014-tower-companies-split-hetnet-technologies/
http://bit.ly/n231	http://www.rcrwireless.com/article/20140521/infrastructure-2/pcia-2014-tower-companies-split-hetnet-technologies/definition/merchant.html
http://bit.ly/n231	http://www.rcrwireless.com/article/20140521/infrastructure-2/pcia-2014-tower-companies-split-hetnet-technologies/pcia-2014-tower-companies-split-hetnet-technologies/
http://bit.ly/nH-U	https://nanohub.org/groups/u
http://j.mp/KkAcun	http://news.mynavi.jp/news/2014/01/16/259/
http://j.mp/KkAcun	http://news.mynavi.jp/news/2014/01/16/259/definition/merchant.html

so, for the above example
url_map create a Map like

http://amzn.to/Zs	[http://www.amazon.com]
http://bit.ly/n231	[http://www.rcrwireless.com/article/20140521/infrastructure-2/pcia-2014-tower-companies-split-hetnet-technologies/, http://www.rcrwireless.com/article/20140521/infrastructure-2/pcia-2014-tower-companies-split-hetnet-technologies/definition/merchant.html, http://www.rcrwireless.com/article/20140521/infrastructure-2/pcia-2014-tower-companies-split-hetnet-technologies/pcia-2014-tower-companies-split-hetnet-technologies/]
http://bit.ly/nH-U	[https://nanohub.org/groups/u]
http://j.mp/KkAcun	[http://news.mynavi.jp/news/2014/01/16/259/, http://news.mynavi.jp/news/2014/01/16/259/definition/merchant.html]
http://cl.ly/Z7Ej	[http://wiki.blender.org/index.php/Dev:Ref/Release_Notes/2.73/More_Features]

In this case http://bit.ly/n231 contains 3 expanded urls and http://j.mp/KkAcun contains 2 expanded urls 

Now, we have to unify the short url by one standard expanded url

The function getLogestURLs(List<String>) do this

The function takes the list of expanded urls and sort the list by the length of expanded URL if exist more than one expanded URLs under a short URL

then take the longest lenth of expanded URL as a standard URL

So, the standard_url_map contains the all uniqe short url mapping with unique expanded url






