namespace UVnaloga
{
    partial class ExitPopup
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.roundButton2 = new UVnaloga.RoundButton();
            this.label1 = new System.Windows.Forms.Label();
            this.roundButton3 = new UVnaloga.RoundButton();
            this.SuspendLayout();
            // 
            // roundButton2
            // 
            this.roundButton2.BackColor = System.Drawing.Color.Green;
            this.roundButton2.FlatAppearance.BorderSize = 0;
            this.roundButton2.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.roundButton2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.1F);
            this.roundButton2.Location = new System.Drawing.Point(727, 308);
            this.roundButton2.Name = "roundButton2";
            this.roundButton2.Size = new System.Drawing.Size(264, 172);
            this.roundButton2.TabIndex = 1;
            this.roundButton2.Text = "Ne";
            this.roundButton2.UseVisualStyleBackColor = false;
            this.roundButton2.Click += new System.EventHandler(this.RoundButton2_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Rockwell", 20.1F);
            this.label1.Location = new System.Drawing.Point(78, 68);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(982, 76);
            this.label1.TabIndex = 2;
            this.label1.Text = "Ali res želite zapreti program?";
            // 
            // roundButton3
            // 
            this.roundButton3.BackColor = System.Drawing.Color.Firebrick;
            this.roundButton3.FlatAppearance.BorderSize = 0;
            this.roundButton3.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.roundButton3.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.1F);
            this.roundButton3.Location = new System.Drawing.Point(159, 308);
            this.roundButton3.Name = "roundButton3";
            this.roundButton3.Size = new System.Drawing.Size(271, 172);
            this.roundButton3.TabIndex = 3;
            this.roundButton3.Text = "Da";
            this.roundButton3.UseVisualStyleBackColor = false;
            this.roundButton3.Click += new System.EventHandler(this.RoundButton3_Click);
            // 
            // ExitPopup
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.SteelBlue;
            this.ClientSize = new System.Drawing.Size(1123, 630);
            this.Controls.Add(this.roundButton3);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.roundButton2);
            this.Name = "ExitPopup";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "ExitPopup";
            this.Load += new System.EventHandler(this.ExitPopup_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private RoundButton roundButton2;
        private System.Windows.Forms.Label label1;
        private RoundButton roundButton3;
    }
}