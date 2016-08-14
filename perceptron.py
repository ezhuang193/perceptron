#TRAINING
height = 20
width = 30
learning_Rate = 0.1
weights = [(height*width)+1]
epoch = 0
training_Size = 3
#max_Iterations = 100 #number of training files we are passing ing

#while epoch++ < max_Iterations:
    #for i in range(1, training_Size+1):
        with open("1.txt") as f:
            while True:
                c = f.read(1)
                if not c:
                    print("End of file")
                    break
                print(c)
