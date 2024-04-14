#from selenium import webdriver
import undetected_chromedriver as uc
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


import time
#service = Service(executable_path="chromedriver.exe")
#driver = uc.Chrome()
#driver = webdriver.Chrome(service=service)

options = uc.ChromeOptions()
profile = "C:/Users/mafia/AppData/Local/Google/Chrome/User Data/Default"
options.add_argument(f"user-data-dir={profile}")
driver = uc.Chrome(options=options,use_subprocess=True)

file = open("../../Credenciais/crendenciais.csv", "r")
dados = file.readline()
login, password = dados.split(",")
file.close()

driver.get("https://www.linkedin.com")
#driver.get("https://bot.incolumitas.com"

WebDriverWait(driver, 5).until(
    EC.presence_of_element_located((By.NAME, "session_key"))
)
login_field = driver.find_element(By.NAME, "session_key")
login_field.clear()
login_field.send_keys(login)

password_field = driver.find_element(By.NAME, "session_password")
password_field.clear()
password_field.send_keys(password)

password_field.send_keys(Keys.ENTER)


time.sleep(100)

driver.quit()
