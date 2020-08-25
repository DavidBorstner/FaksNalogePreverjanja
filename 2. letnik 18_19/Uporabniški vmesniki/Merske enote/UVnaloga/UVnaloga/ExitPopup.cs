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
    public partial class ExitPopup : Form
    {
        public ExitPopup()
        {
            InitializeComponent();
            MaximizeBox = false;
            MinimizeBox = false;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
        }

        private void RoundButton1_Click(object sender, EventArgs e)
        {
            this.Close();
            Application.Exit();
        }

        private void RoundButton2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form1 nov = new Form1();
            nov.Show();
        }

        private void ExitPopup_Load(object sender, EventArgs e)
        {

        }

        private void RoundButton3_Click(object sender, EventArgs e)
        {
            this.Close();
            Application.Exit();
        }
    }
}
