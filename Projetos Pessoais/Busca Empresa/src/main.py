from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time


service = Service(executable_path="chromedriver.exe")
driver = webdriver.Chrome(service=service)

driver.get("https://www.econodata.com.br/maiores-empresas/pb-joao-pessoa/tecnologia")

WebDriverWait(driver, 5).until(
    EC.presence_of_element_located((By.ID, "__nuxt"))
)

#for empresa in fi

time.sleep(10)

driver.quit()
