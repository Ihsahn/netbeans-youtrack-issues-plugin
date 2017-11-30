/*
 * Copyright 2017 George Aristy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.llorllale.netbeans.youtrack.issues;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.llorllale.youtrack.api.Field;
import org.llorllale.youtrack.api.FieldValue;
import org.llorllale.youtrack.api.Issue;
import org.llorllale.youtrack.api.Issues.IssueSpec;
import org.llorllale.youtrack.api.Project;

/**
 * Default {@link IssueDetails} that exposes the details to the end user via a {@link JPanel}. 
 * The fields are currently read-only. The {@link #asSpec()} will need refactoring if the fields
 * are to be editable.
 * 
 * <p>For testing purposes, several components can be access with these names as reference:
 * 
 * <ul>
 *   <li><strong>ID:</strong> -> "issueIdTxtBox"</li>
 *   <li><strong>Created By:</strong> -> "createdByTxtBox"</li>
 *   <li><strong>Created On:</strong> -> "createdOnTxtBox"</li>
 *   <li><strong>Summary:</strong> -> "summaryTxtBox"</li>
 *   <li><strong>Description:</strong> -> "descriptionTxtBox"</li>
 *   <li><strong>Fields:</strong> -> "fieldsTable"</li>
 * </ul>
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @since 0.2.0
 */
@SuppressWarnings("checkstyle:ClassDataAbstractionCoupling")
public final class DefaultIssueDetails extends JPanel implements IssueDetails {
  private static final long serialVersionUID = -7596322055876803429L;

  private final Issue issue;

  /** 
   * Ctor.
   * 
   * @param issue the YouTrack issue to display to the end user
   * @since 0.2.0
   */
  public DefaultIssueDetails(Issue issue) {
    this.issue = issue;
    this.initComponents();
    this.populateViewWith(this.issue);
  }

  /**
   * Populates this views fields with the issue's details.
   * 
   * @param iss the issue with details to show to the end user
   */
  private void populateViewWith(Issue iss) {
    this.issueIdTxtBox.setText(iss.id());
    this.createdOnTxtBox.setText(
        DateTimeFormatter.ofPattern("YYYY/MM/dd HH:mm:ss", Locale.getDefault())
            .withZone(ZoneId.systemDefault())
            .format(iss.creationDate())
    );
    this.summaryTxtBox.setText(iss.summary());
    iss.description().ifPresent(this.descriptionTxtBox::setText);
    this.fieldsTable.setModel(new FieldsModel(iss));
  }

  @Override
  public IssueSpec asSpec() {
    IssueSpec spec; 
    
    if (Objects.nonNull(this.descriptionTxtBox.getText())) {
      spec = new IssueSpec(
          this.summaryTxtBox.getText(), 
          this.descriptionTxtBox.getText()
      );
    } else {
      spec = new IssueSpec(this.summaryTxtBox.getText());
    }

    for (int i = 0; i < this.fieldsTable.getRowCount(); i++) {
      final String fieldName = this.fieldsTable.getValueAt(i, 0).toString();
      final String fieldValue = this.fieldsTable.getValueAt(i, 1).toString();
      spec = spec.with(
          new Field(){
            @Override
            public Project project() {
              throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public String name() {
              return fieldName;
            }

            @Override
            public boolean equals(Object object) {
              final boolean equals;

              if (!(object instanceof Field)) {
                equals = false;
              } else {
                final Field other = (Field) object;
                equals = this.name().equals(other.name());
              }

              return equals;
            }
          }, 
          new FieldValue(){
            @Override
            public Field field() {
              throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public String asString() {
              return fieldValue;
            }

            @Override
            public boolean equals(Object object) {
              final boolean equals;

              if (!(object instanceof FieldValue)) {
                equals = false;
              } else {
                final FieldValue other = (FieldValue) object;
                equals = this.asString().equals(other.asString());
              }

              return equals;
            }
          }
      );
    }
    return spec;
  }

  @Override
  public JComponent asView() {
    return this;
  }

  //@checkstyle.OFF: GENERATED CODE

  /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    creationDateLbl = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    issueIdTxtBox = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    createdOnTxtBox = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    summaryTxtBox = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    descriptionTxtBox = new javax.swing.JTextArea();
    jLabel6 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    fieldsTable = new javax.swing.JTable();

    org.openide.awt.Mnemonics.setLocalizedText(creationDateLbl, org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.creationDateLbl.text")); // NOI18N
    creationDateLbl.setName("creationDateLbl"); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.jLabel1.text")); // NOI18N

    issueIdTxtBox.setEditable(false);
    issueIdTxtBox.setText(org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.issueIdTxtBox.text")); // NOI18N
    issueIdTxtBox.setName("issueIdTxtBox"); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.jLabel3.text")); // NOI18N

    createdOnTxtBox.setEditable(false);
    createdOnTxtBox.setText(org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.createdOnTxtBox.text")); // NOI18N
    createdOnTxtBox.setName("createdOnTxtBox"); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.jLabel4.text")); // NOI18N

    summaryTxtBox.setEditable(false);
    summaryTxtBox.setText(org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.summaryTxtBox.text")); // NOI18N
    summaryTxtBox.setName("summaryTxtBox"); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.jLabel5.text")); // NOI18N

    descriptionTxtBox.setColumns(20);
    descriptionTxtBox.setRows(5);
    descriptionTxtBox.setName("descriptionTxtBox"); // NOI18N
    jScrollPane1.setViewportView(descriptionTxtBox);

    org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(DefaultIssueDetails.class, "DefaultIssueDetails.jLabel6.text")); // NOI18N

    fieldsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    fieldsTable.setName("fieldsTable"); // NOI18N
    jScrollPane2.setViewportView(fieldsTable);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel6)
          .addComponent(jLabel5)
          .addComponent(jLabel4))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(issueIdTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(createdOnTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(250, 250, 250)
            .addComponent(creationDateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 12, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1)
              .addComponent(summaryTxtBox)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel1)
            .addComponent(issueIdTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3)
            .addComponent(createdOnTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(creationDateLbl))
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(summaryTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel5)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6))
        .addContainerGap(273, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField createdOnTxtBox;
  private javax.swing.JLabel creationDateLbl;
  private javax.swing.JTextArea descriptionTxtBox;
  private javax.swing.JTable fieldsTable;
  private javax.swing.JTextField issueIdTxtBox;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextField summaryTxtBox;
  // End of variables declaration//GEN-END:variables

  //@checkstyle.ON: GENERATED CODE
}
