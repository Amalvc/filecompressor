/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import project1.Compress;
import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project1.Decompressor;


/**
 *
 * @author bair7
 */
public class View extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompreButton;
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressButton = new JButton("Select a file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);
        decompreButton=new JButton("Select a file to decompress");
        decompreButton.addActionListener(this);
        decompreButton.setBounds(250,100,200,30);
        this.add(compressButton);
        this.add(decompreButton);
        this.setSize(500,200);
        this.getContentPane().setBackground(Color.red);
        
    }
    @Override
    
    public void actionPerformed(ActionEvent e){
       if(e.getSource() == compressButton){
           JFileChooser filechooser=new JFileChooser();
           int response=filechooser.showSaveDialog(null);
           if(response == JFileChooser.APPROVE_OPTION){
               File file=new File(filechooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);
               try{
                   Compress.method(file);
                   JOptionPane.showMessageDialog(null, "compression successful");
               }
               catch(Exception excp){
                   JOptionPane.showMessageDialog(null, excp.toString());
               }
           }
       }
       if(e.getSource()==decompreButton){
           JFileChooser filechooser=new JFileChooser();
           int response=filechooser.showSaveDialog(null);
           if(response == JFileChooser.APPROVE_OPTION){
               File file=new File(filechooser.getSelectedFile().getAbsolutePath());
               System.out.println(file);
               try{
                   Decompressor.method(file);
                   JOptionPane.showMessageDialog(null, "Decompression successful");
               }
               catch(Exception excp){
                   JOptionPane.showMessageDialog(null, excp.toString());
               }
           }
       }
    }
            
    public static void main(String[] args){
        View frame=new View();
        frame.setVisible(true);
    }
}
