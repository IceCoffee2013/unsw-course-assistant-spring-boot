import urllib.request
import re
import csv
'''
Created on 26 Sep. 2017

@author: yuyao
'''



def getHtml(url):
    page =  urllib.request.urlopen(url)
    html = page.read()
    html=html.decode('utf-8')#python3
    return html


def getHref(html):
    reg = r'<A href="(.+?\.html)">'
    hrefre = re.compile(reg)
    hrelist = re.findall(hrefre,html)
    return hrelist 

def getNameAndId(html,url):
    reg = r'<h1>(.+?)</h1>'
    nameAndIdre = re.compile(reg)
    nameAndIdlist = re.findall(nameAndIdre,html)
    if(len(nameAndIdlist)==1):
        print(url)
        return ["",""]
    temp = nameAndIdlist[1].split(" - ")
    length= len(temp)
    name = ""
    if length > 2:
        for i in range(length-1):
            name = name +  temp[i]
                      
    else:
        name = temp[0]
    return [name, temp[-1]]


def getSchool(html):
    reg = r'<p><strong>School:.+>(.+?)</a></p><p><strong>Course Outline:'
    schooldre = re.compile(reg)
    schoollist = re.findall(schooldre,html)
    if len(schoollist) != 0:
        return schoollist[0].replace("&nbsp;","")
    else:
        reg = r'<p><strong>School:.+>(.+?)</p><p><strong>Course Outline:'
        schooldre = re.compile(reg)
        schoollist = re.findall(schooldre,html)
        return schoollist[0].replace("&nbsp;","")
    
def getFaculty(html):
    reg = r'<p><strong>Faculty:.+>(.+?)</a></p>'
    facultydre = re.compile(reg)
    facultylist = re.findall(facultydre,html)
    if len(facultylist) != 0:
        return facultylist[0].replace("&nbsp;","")
    else:
        reg = r'<p><strong>Faculty:.+>(.+?)</p>'
        facultydre = re.compile(reg)
        facultylist = re.findall(facultydre,html)
        return facultylist[0].replace("&nbsp;","")
def getCareer(html):
    reg = r'<p><strong>Career:</strong>&nbsp;(.+?)</p>'
    careerre = re.compile(reg)
    careerlist = re.findall(careerre,html)
    return careerlist[0]  

def getCredit(html):
    reg = r'<p><strong>Units of Credit:</strong>&nbsp;(.+?)</p>'
    creditre= re.compile(reg)
    creditlist = re.findall(creditre,html)
    return creditlist[0]


def getRequirements(html):
    requirementsToEnd = html.split("<p><strong>Enrolment Requirements:</strong></p>")
    #print(requirementsToEnd[1])
    if(len(requirementsToEnd) == 1): return ""
    requirementslist = requirementsToEnd[1].split("<p>",2)
    return requirementslist[1].replace("</p>",'')


def getDescription(html):
    descriptionToEnd = html.split("<h2>Description</h2><!-- Start Course Description -->")

    descriptionList = descriptionToEnd[1].split("<!-- End Course description -->")
    description= descriptionList[0].replace("\n","").replace("<div>","").replace("</div>","").replace("                                        ","")
    return description

def writeToCsv(csvrow):
    writer.writerow(csvrow) 
#url = "http://www.handbook.unsw.edu.au/postgraduate/courses/2018/CVEN9855.html"  

csvfile = open('postgraduate.csv', 'wt', newline='', encoding='utf-8')  
writer = csv.writer(csvfile)  
#html = getHtml("http://www.handbook.unsw.edu.au/undergraduate/courses/2018/CVEN9855.html")
htmls = getHtml("http://www.handbook.unsw.edu.au/vbook2018/brCoursesByAtoZ.jsp?StudyLevel=Postgraduate&descr=All")
htmlList = getHref(htmls)
csvrow = []
print(len(htmlList))
for url in htmlList:
    csvrow = []
    html = getHtml(url)
    #print(html)
    #print(url)
    name,id = getNameAndId(html,url)
    csvrow.append(id)
    csvrow.append(name)

 
      
    faculty = getFaculty(html)
    csvrow.append(faculty)
    #print(faculty)
      
    school = getSchool(html)
    csvrow.append(school)
    #print(school)
      
    career = getCareer(html)
    csvrow.append(career)
    #print(career)
      
    requirement = getRequirements(html)
    csvrow.append(requirement)
    #print(requirement)
      
    description = getDescription(html)
    csvrow.append(description)
    #print(description)
     
    writeToCsv(csvrow)


# html = getHtml(url)
# print(html)
# nameAndId = getNameAndId(html)
# print(nameAndId)
#    
# faculty = getFaculty(html)
# print(faculty)
#    
# school = getSchool(html)
# print(school)
#    
# career = getCareer(html)
# print(career)
#    
# requirement = getRequirements(html)
# print(requirement)
#    
# description = getDescription(html)
# print(description)

