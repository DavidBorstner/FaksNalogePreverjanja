namespace UVnaloga
{
    partial class Form1
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.imageList1 = new System.Windows.Forms.ImageList(this.components);
            this.dolzinaGumb = new System.Windows.Forms.Button();
            this.povrsinaGumb = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.roundButton1 = new UVnaloga.RoundButton();
            this.SuspendLayout();
            // 
            // imageList1
            // 
            this.imageList1.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("imageList1.ImageStream")));
            this.imageList1.TransparentColor = System.Drawing.Color.Transparent;
            this.imageList1.Images.SetKeyName(0, "polje.jpg");
            this.imageList1.Images.SetKeyName(1, "ravnilo.jpg");
            this.imageList1.Images.SetKeyName(2, "kocka.jpg");
            this.imageList1.Images.SetKeyName(3, "kocka2.png");
            this.imageList1.Images.SetKeyName(4, "polje2.png");
            this.imageList1.Images.SetKeyName(5, "termometer.png");
            this.imageList1.Images.SetKeyName(6, "igrise.jpg");
            this.imageList1.Images.SetKeyName(7, "igrise2.png");
            this.imageList1.Images.SetKeyName(8, "flasa.png");
            // 
            // dolzinaGumb
            // 
            this.dolzinaGumb.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.dolzinaGumb.FlatAppearance.BorderSize = 0;
            this.dolzinaGumb.FlatAppearance.MouseOverBackColor = System.Drawing.Color.LightSkyBlue;
            this.dolzinaGumb.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.dolzinaGumb.Font = new System.Drawing.Font("Rockwell", 30.1F);
            this.dolzinaGumb.ImageIndex = 1;
            this.dolzinaGumb.ImageList = this.imageList1;
            this.dolzinaGumb.Location = new System.Drawing.Point(293, 131);
            this.dolzinaGumb.Name = "dolzinaGumb";
            this.dolzinaGumb.Size = new System.Drawing.Size(245, 213);
            this.dolzinaGumb.TabIndex = 0;
            this.dolzinaGumb.Text = "dolžina";
            this.dolzinaGumb.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.dolzinaGumb.UseVisualStyleBackColor = true;
            this.dolzinaGumb.Click += new System.EventHandler(this.Button1_Click);
            // 
            // povrsinaGumb
            // 
            this.povrsinaGumb.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.povrsinaGumb.FlatAppearance.BorderSize = 0;
            this.povrsinaGumb.FlatAppearance.MouseOverBackColor = System.Drawing.Color.LightSkyBlue;
            this.povrsinaGumb.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.povrsinaGumb.Font = new System.Drawing.Font("Rockwell", 30.1F);
            this.povrsinaGumb.ImageIndex = 7;
            this.povrsinaGumb.ImageList = this.imageList1;
            this.povrsinaGumb.Location = new System.Drawing.Point(574, 131);
            this.povrsinaGumb.Name = "povrsinaGumb";
            this.povrsinaGumb.Size = new System.Drawing.Size(258, 223);
            this.povrsinaGumb.TabIndex = 1;
            this.povrsinaGumb.Text = "površina";
            this.povrsinaGumb.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.povrsinaGumb.UseVisualStyleBackColor = true;
            this.povrsinaGumb.Click += new System.EventHandler(this.Button2_Click);
            // 
            // button3
            // 
            this.button3.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.button3.FlatAppearance.BorderSize = 0;
            this.button3.FlatAppearance.MouseOverBackColor = System.Drawing.Color.LightSkyBlue;
            this.button3.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button3.Font = new System.Drawing.Font("Rockwell", 30.1F);
            this.button3.ImageIndex = 8;
            this.button3.ImageList = this.imageList1;
            this.button3.Location = new System.Drawing.Point(831, 350);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(343, 265);
            this.button3.TabIndex = 2;
            this.button3.Text = "prostornina";
            this.button3.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.Button3_Click);
            // 
            // label1
            // 
            this.label1.Anchor = System.Windows.Forms.AnchorStyles.Top;
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Rockwell", 46F);
            this.label1.Location = new System.Drawing.Point(59, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(2671, 172);
            this.label1.TabIndex = 4;
            this.label1.Text = "MERSKE ENOTE ZA OSNOVNE ŠOLE";
            this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.label1.Click += new System.EventHandler(this.Label1_Click);
            // 
            // button1
            // 
            this.button1.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.button1.FlatAppearance.BorderSize = 0;
            this.button1.FlatAppearance.MouseOverBackColor = System.Drawing.Color.LightSkyBlue;
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.Font = new System.Drawing.Font("Rockwell", 30.1F);
            this.button1.ImageIndex = 5;
            this.button1.ImageList = this.imageList1;
            this.button1.Location = new System.Drawing.Point(0, 350);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(371, 250);
            this.button1.TabIndex = 5;
            this.button1.Text = "temperatura";
            this.button1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.Button1_Click_2);
            // 
            // roundButton1
            // 
            this.roundButton1.BackColor = System.Drawing.Color.Firebrick;
            this.roundButton1.FlatAppearance.BorderColor = System.Drawing.Color.Black;
            this.roundButton1.FlatAppearance.BorderSize = 0;
            this.roundButton1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.roundButton1.Font = new System.Drawing.Font("Rockwell", 30.1F);
            this.roundButton1.ForeColor = System.Drawing.Color.Black;
            this.roundButton1.Location = new System.Drawing.Point(311, 592);
            this.roundButton1.Name = "roundButton1";
            this.roundButton1.Size = new System.Drawing.Size(557, 189);
            this.roundButton1.TabIndex = 3;
            this.roundButton1.Text = "izhod";
            this.roundButton1.UseVisualStyleBackColor = false;
            this.roundButton1.Click += new System.EventHandler(this.RoundButton1_Click);
            // 
            // Form1
            // 
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None;
            this.BackColor = System.Drawing.Color.SteelBlue;
            this.ClientSize = new System.Drawing.Size(1166, 827);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.roundButton1);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.povrsinaGumb);
            this.Controls.Add(this.dolzinaGumb);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ImageList imageList1;
        private System.Windows.Forms.Button dolzinaGumb;
        private System.Windows.Forms.Button povrsinaGumb;
        private System.Windows.Forms.Button button3;
        private RoundButton roundButton1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button1;
    }
}

