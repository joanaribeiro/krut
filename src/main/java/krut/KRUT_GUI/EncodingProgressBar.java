/*
 * EncodingProgressBar.java
 *
 * Created on 15. januar 2007, 16:04
 */

package krut.KRUT_GUI;

/**
 *
 *  @author  Jonas
 */

 /**  This Class provides a JProgressBar that gives at least a
 *  sense of progress during encoding and merging of the
 *  movie files.
 *
 *  It needs to have a DataList object assigned to it, and
 *  this is currently done by the ScreenGrabber object 
 *  (in the EncodeThread constructor).
 *
 *  The EncodingProgressBar has three values for currentStatus:
 *  ENCODING, MERGING and ABORTING. currentStatus
 *  has to be set through the setStatus(int status)
 *  method.
 *
 *  The EncodingProgressBar can cancel encoding of movies
 *  fairly easy, by telling the DataList object that there
 *  are no more frames. This is done in the private cancelAction()
 *  method.
 *
 *  The cancellation of the merging process is just done
 *  by setting the cancelled flag to true.
 *  The EncodingProgressBar is given as an argument 
 *  to the Merge object (in the method Run_KRUT.stopAction()),
 *  so the run() method of the Merge object will monitor
 *  the cancelled flag. If cancelled is true, the Merge
 *  object will attempt to stop it's merging Thread.
 *  The ugly way. This is done in the Merge.doMerge() method.
 */
public class EncodingProgressBar extends javax.swing.JFrame {
    
    /** This is the DataList used to cancel the
     *  encoding of the movies. This is set
     *  from the ScreenGrabber in the EncodeThread
     *  constructor.
     */
    public krut.KRUT_Recording.DataList myDataList;
    /** The output window for this EncodingProgressBar.
     */
    public OutputText myOutput;
    /** The cancelled flag. This can be used to monitor
     *  if the encoding or merging have been requested to
     *  cancel.
     */
    public boolean cancelled = false;
    
    /** The current status of this EncodingProgressBar
     */
    protected int currentStatus;

    /** The ENCODING status. */
    static final public int ENCODING = 1;
    /** The MERGING status. */
    static final public int MERGING = 2;
    /** The ABORTING status. */
    static final public int ABORTING = 3;
    
    /** Sets the current status.
     *
     *  @param  status  The current status of the program.
     */
    public void setStatus(int status) {
        if (status == ENCODING) {
            this.jProgressBar1.setString("Encoding video...");
        } else if (status == MERGING) {
            this.jProgressBar1.setString("Merging mov file...");
        } else if (status == ABORTING) {
            this.jProgressBar1.setString("Aborting...");
        }
        currentStatus = status;
    }
        
    /** This method tries to cancel the encoding of the movie.
     *  The myDataList and myOutput paramaters must be non-null
     *  at this point, or this method will just pring an error
     *  message.
     */
    private void cancelAction() {
        /** Setting the cancelled flag to true
         *  causes Merge to be cancelled in the Merge.doMerge() method. */
        cancelled = true;
        try {
            if (currentStatus == ENCODING) {
                /** Setting the myDataList.finished flag to true,
                 *  will cause the DataList to signal the end of 
                 *  the movie file, and in that way stop encoding
                 *  smoothly.
                 */
                myDataList.finished = true;
                myOutput.out("Encoding of video interrupted");
                myOutput.out("Recording cancelled");            
            }
            if (currentStatus == MERGING) {
                myOutput.out("Merging of video and audio interrupted");
                myOutput.out("Recording cancelled");                            
            }
        } catch (NullPointerException npe) {
            System.out.println("cancelled uninitiated progress bar");
        }
        myOutput.out("");
        setStatus(ABORTING);
    }
    
    /** Creates new form EncodingProgressBar */
    public EncodingProgressBar() {
        initComponents();
    }
    
    /** Creates new form EncodingProgressBar
     *  
     *  @param out  The output window for this progress bar
     */
    public EncodingProgressBar(OutputText out) {
        myOutput = out;
        initComponents();
        setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Krut data processing");
        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setPreferredSize(new java.awt.Dimension(200, 18));
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1, new java.awt.GridBagConstraints());

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton1, new java.awt.GridBagConstraints());

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        cancelAction();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncodingProgressBar().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
    
}
