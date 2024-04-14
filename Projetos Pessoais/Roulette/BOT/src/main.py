import undetected_chromedriver as uc
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


import time
options = uc.ChromeOptions()
profile = "C:/Users/mafia/AppData/Local/Google/Chrome/User Data/Default"
options.add_argument(f"user-data-dir={profile}")
driver = uc.Chrome(options=options,use_subprocess=True)
driver.get("https://www.pokerstars.com/?no_redirect=1")


time.sleep(5)

driver.quit()
