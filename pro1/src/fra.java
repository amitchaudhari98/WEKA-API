import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.filters.Filter;
import java.util.Scanner;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import javax.swing.*;

public class fra extends javax.swing.JFrame {

    Integer split=0;
    
    public fra() {
        initComponents();
        getContentPane().setBackground(Color.ORANGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WEKA");
        setBackground(java.awt.Color.orange);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(java.awt.Color.red);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Dataset :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(155, 55, 155));
        jComboBox1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KDD99", "GureKDD", "NSLKDD" }));
        jComboBox1.setAutoscrolls(true);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 100, -1));

        jLabel2.setBackground(java.awt.Color.red);
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Training Split :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jComboBox2.setBackground(new java.awt.Color(155, 55, 155));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50%", "60%", "70%", "80%", "90%" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        jLabel3.setBackground(java.awt.Color.red);
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("Testing Split :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50%", "40%", "30%", "20%", "10%" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(java.awt.Color.yellow);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 1560, 900));

        jButton1.setBackground(java.awt.Color.black);
        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Result");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 120, 50));

        jLabel4.setBackground(java.awt.Color.yellow);
        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 29)); // NOI18N
        jLabel4.setForeground(java.awt.Color.red);
        jLabel4.setText("Intrusion Detection System Using KDD dataset and Naive Bayes Algorithm");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed
   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).equals("KDD99"))
        {
             try
             {     
                 BufferedReader breader = null;
                   breader = new BufferedReader(new FileReader("F:/KDDcup99.arff"));
                   Instances train = new Instances(breader);
                   train.setClassIndex(train.numAttributes()-1);
        
                   breader.close();
                   
               if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("50%"))
               {   final long startTime = System.nanoTime();
                   jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                   split=50;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ 
                     jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                     i++;
                 }while(i<train.numAttributes());
                 
                 
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString()); 
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                 
                } 
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("60%"))
                {  final long startTime = System.nanoTime();
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                  split=60;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
                else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("70%"))
                {   final long startTime = System.nanoTime();
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                      split=70;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
                else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("80%"))
                {   final long startTime = System.nanoTime();
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                     split=80;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
                else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("90%"))
                {   final long startTime = System.nanoTime(); 
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                     split=90;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString()); 
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
               
            }catch(Exception ee){}
             
        }
        
        
        
        else if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).equals("GureKDD"))
        {
            
          try
             {     BufferedReader breader = null;
                   breader = new BufferedReader(new FileReader("F:/Gurekdd.arff"));
                   Instances train = new Instances(breader);
                   train.setClassIndex(train.numAttributes()-1);
        
                   breader.close();
               if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("50%"))
               {   final long startTime = System.nanoTime();
                   jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                   split=50;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                 
                } 
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("60%"))
                {  final long startTime = System.nanoTime();
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                  split=60;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
               
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("70%"))
                {   final long startTime = System.nanoTime();
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                      split=70;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
                
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("80%"))
                {   final long startTime = System.nanoTime();
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                     split=80;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                }
                
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("90%"))
                {   final long startTime = System.nanoTime(); 
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                     split=90;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());      
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
               
            }catch(Exception ee){}   
          
        }
        
        
        
        else if(jComboBox1.getItemAt(jComboBox1.getSelectedIndex()).equals("NSLKDD"))
        {
            
          try
             {     BufferedReader breader = null;
                   breader = new BufferedReader(new FileReader("F:/NSLKDD.arff"));
                   Instances train = new Instances(breader);
                   train.setClassIndex(train.numAttributes()-1);
        
                   breader.close();
               if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("50%"))
               {   final long startTime = System.nanoTime();
                   jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                   split=50;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());      
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                } 
               
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("60%"))
                {  final long startTime = System.nanoTime();
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                  split=60;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
               
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("70%"))
                {   final long startTime = System.nanoTime(); 
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                      split=70;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
                
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("80%"))
                {   final long startTime = System.nanoTime(); 
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                     split=80;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration+"sec");
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\n"+eval.toMatrixString()); 
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                }
                
               else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("90%"))
                {   final long startTime = System.nanoTime(); 
                    final long startTime1 = System.nanoTime(); 
                    jComboBox3.setSelectedIndex(jComboBox2.getSelectedIndex());
                     split=90;
                 RemovePercentage rp = new RemovePercentage();
                 rp.setPercentage(split);
                 rp.setInputFormat(train);
                 train = Filter.useFilter(train, rp);
                 
                 float duration = System.nanoTime() - startTime;
                 duration/=1000000000;
                 
                 jTextArea1.append("\n\nTIme Taken to Split Training Set : "+duration+"sec");

        
                 NaiveBayes nB= new NaiveBayes();
                 nB.buildClassifier(train);
                 Evaluation eval = new Evaluation(train);
                 eval.crossValidateModel(nB,train,10,new Random(1));
                 
                 jTextArea1.setText("Relation :"+train.relationName()+"\nInstances :"+train.numInstances()+"\nAttributes :"+train.numAttributes());
                 int i =0;
                 do{ jTextArea1.append("\n"+"\t"+"   "+train.attribute(i).toString());
                 i++;
                 }while(i<train.numAttributes());
                 
                 jTextArea1.append("\n\nTest Mode: Split "+split+" %"+"train,remainder test");
                 float duration1 = System.nanoTime() - startTime1;
                 duration1/=1000000000;
                 
                 jTextArea1.append(eval.toSummaryString("\n\n\n======Evaluation on Test Split====== \n=======Summary ========\n",true));
                 jTextArea1.append("\n"+eval.fMeasure(1) +""+eval.precision(1)+""+eval.recall(1));
                 jTextArea1.append("\n\nTIme Taken to Build the Model : "+duration1+"sec");
                 jTextArea1.append("\n\n"+eval.toMatrixString());
                 jTextArea1.append("\n\n"+eval.toClassDetailsString());
                 
                }
               
            }catch(Exception ee){}   
          
        }
             
             
             
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("50%"))
        {
            jComboBox3.setSelectedItem("50%");
            jComboBox3.setEnabled(false);
        }
        else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("60%"))
        {
            jComboBox3.setSelectedItem("40%");
            jComboBox3.setEnabled(false);       
        }
        else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("70%"))
        {    jComboBox3.setSelectedItem("30%");
             jComboBox3.setEnabled(false);     
        }else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("80%"))
        {jComboBox3.setSelectedItem("20%");
            jComboBox3.setEnabled(false);
        }else if(jComboBox2.getItemAt(jComboBox2.getSelectedIndex()).equals("90%"))
        {   jComboBox3.setSelectedItem("10%");
            jComboBox3.setEnabled(false);
    }             
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
