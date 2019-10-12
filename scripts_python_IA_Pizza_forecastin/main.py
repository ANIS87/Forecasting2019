import numpy as np
import pandas as pd
import statsmodels.api as sm
import matplotlib.pyplot as plt  
import datetime as dt
file_csv='data/pizzeria_tania_data_simplified.csv'


def train_model(file_csv,M,p):

  '''
  lire le fichier CSV pour constuire un data frame
  file_csv: nom fichier csv
  M:nombre d'echantillon
  p:declage entre train et test
  
  '''
  training_res=None
  #lire les donnes
  df = pd.read_csv(file_csv, delimiter=',',nrows = M) 
  #creer les vairbales entree et sortie 
  df = df.rename(columns={'count':'sales'})
  df['Timestamp'] = df.apply(lambda row: dt.datetime(row.year, row.month, row.day, row.hour), 
                           axis=1)
  df['Timestamp'] = pd.to_datetime(df.Timestamp)
  df.index= pd.DatetimeIndex(df.Timestamp)
  nRow, nCol = df.shape 
  size_test=int(nRow*0.8)
  #split data train /test
  train=df.iloc[0:size_test]
  test=df.iloc[size_test+p::]  
  #entrainer le model
  training_mod = sm.tsa.SARIMAX(train.sales, order=(4,1,1))
  training_res = training_mod.fit()
  return df, training_res


def testerModel(training_res, data,date_satrt, date_end):
    #tester le model entre deux dates 
    predictions = training_res.predict(start = date_satrt, end = date_end).abs()
    real_values=data.sales.ix[date_satrt:date_end]
    Taille= len(real_values)
    forecast_error = real_values - predictions
    error=np.sqrt(np.sum(forecast_error**2) / Taille)
    return predictions ,real_values, error

def plot_figure(predictions,real_values ,error,name_png): 
  plt.figure(figsize=(15, 7))
  plt.plot(predictions, color='r', label="Predicted values")
  plt.plot(real_values, label="Real values")
  plt.title("Mean Absolute Percentage Error: {0:.2f}%".format(error))
  plt.legend()
  plt.grid(True);
  plt.savefig(name_png)
  #plt.show()

def date_to_string(x):
  y=x.split( )
  z= str(y[0]+'_'+'_'.join(y[1].split(':')))
  return z  

def getresultsoflistdates(L):
   for dd in L:
        date_start=dd[0]
        date_end=dd[1]
        name_png='images/result_foredastin_from_{0}_to_{1}.png'.format(date_to_string(date_start),date_to_string(date_end))
        predictions ,real_values, error=testerModel(training_res,df,date_start,date_end)  
        plot_figure(predictions,real_values ,error,name_png)


if __name__=='__main__':

  df,training_res=train_model(file_csv,100000,10)
  date_start='2016-10-15 01:00:00'
  date_end='2016-11-15 01:00:00'
  name_png='images/result_foredastin_from_{0}_to_{1}.png'.format(date_to_string(date_start),date_to_string(date_end))
  predictions ,real_values, error=testerModel(training_res,df,date_start,date_end)  
  plot_figure(predictions,real_values ,error,name_png)
  #AUTRES EXEMPLES
  Liste_dates=[('2016-10-15 01:00:00','2016-10-25 01:00:00'),('2017-09-15 01:00:00','2017-09-25 10:00:00')]
  getresultsoflistdates(Liste_dates)

