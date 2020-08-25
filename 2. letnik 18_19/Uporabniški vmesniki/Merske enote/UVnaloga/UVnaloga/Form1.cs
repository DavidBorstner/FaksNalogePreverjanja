using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UVnaloga
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            MaximizeBox = false;
            MinimizeBox = false;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            dolzina m = new dolzina();
            m.Show();
            this.Hide();
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            povrsina m = new povrsina();
            m.Show();
            this.Hide();
        }

        private void Button1_Click_1(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            Prostornina nov = new Prostornina();
            nov.Show();
            this.Hide();
        }

        private void RoundButton1_Click(object sender, EventArgs e)
        {
            ExitPopup nov = new ExitPopup();
            nov.Show();
            this.Hide();
        }

        private void Label1_Click(object sender, EventArgs e)
        {

        }

        private void Button1_Click_2(object sender, EventArgs e)
        {
           temperatura nov = new temperatura();
            nov.Show();
            this.Hide();
        }
    }
}
